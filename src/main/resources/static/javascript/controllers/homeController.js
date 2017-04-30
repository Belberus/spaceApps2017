angular.module('appFire')

    .controller('homeCtrl', ['$scope', '$state', 'app', function ($scope, $state, app) {

        $scope.json = "";
        var mymap = L.map('mapid').setView([40.489, -3.6827], 6);

        var state = 0;

        var latOrigen = "";
        var lngOrigen = "";
        var latDestino = "";
        var lngDestino = "";

        var tearIcon = L.icon({
            iconUrl: 'http://www.pd4pic.com/images/drop-water-weather-rain-liquid-tear-droplet.png',
            iconSize:     [15, 15], // size of the icon
            iconAnchor:   [22, 94], // point of the icon which will correspond to marker's location
            popupAnchor:  [-3, -76] // point from which the popup should open relative to the iconAnchor
        });

        function getColor(d) {
            return d > 10 ? '#800026' :
                d > 9  ? '#BD0026' :
                    d > 8  ? '#E31A1C' :
                        d > 7  ? '#FC4E2A' :
                            d > 6   ? '#FD8D3C' :
                                d > 5   ? '#FEB24C' :
                                    d > 4   ? '#FED976' :
                                        d > 3 ? '#FFEDA0':
                                            d > 2 ? '#f6ffcb':
                                                 '#fffff5';
        }

        $scope.colores = ['#FFEDA0','#FED976','#FEB24C','#FD8D3C','#FC4E2A','#E31A1C','#BD0026','#BD0026','#800026','#800026'];

        var control = L.Routing.control({}).addTo(mymap);
        L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
            attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
        }).addTo(mymap);

        var legend = L.control({position: 'bottomright'});

        legend.onAdd = function (mymap) {
            var div = L.DomUtil.create('div', 'info legend'),
                grades = [1,2,3, 4, 5, 6, 7, 8, 9, 10],
                labels = [];

            // loop through our density intervals and generate a label with a colored square for each interval
            for (var i = 0; i < grades.length; i++) {
                div.innerHTML +=
                    '<i style="background:' + getColor(grades[i] + 1) + '"></i> ' +
                    grades[i] + (grades[i + 1] ? '&ndash;' + grades[i + 1] + '<br>' : '+');
            }
            return div;
        };
        legend.addTo(mymap);

        var getDistance = function(lat1,long1, lat2, long2) {
            var aux1 = lat2 - lat1;
            var aux2 = long2 - long1;
            var aux3 = Math.sqrt(aux1*aux1 + aux2*aux2);
            return aux3;
        }

        var water = L.circle([50, 50],{radius: 0}).addTo(mymap).bindPopup("I'm a deep water deposit.");
        app.getFires(function (data) {
            $scope.json = data.fuego_agua;
            for (var i = 0; i < Object.keys($scope.json).length; i++) {
                var circle = L.circle([$scope.json[i].latf, $scope.json[i].longf], {
                    color: $scope.colores[Math.round($scope.json[i].intensity)],
                    fillColor: $scope.colores[Math.round($scope.json[i].intensity)],
                    fillOpacity: 0.5,
                    radius: 400
                }).addTo(mymap);

                circle.on('click', function(e) {
                    var latfuego, longfuego, latagua, longagua;
                    latfuego = $scope.json[0].latf;
                    longfuego = $scope.json[0].longf;
                    latagua = $scope.json[0].lata;
                    longagua = $scope.json[0].longa;
                    for (var i = 1; i < Object.keys($scope.json).length; i++) {
                        if(getDistance(e.latlng.lat,e.latlng.lng,$scope.json[i].latf,$scope.json[i].longf)<getDistance(e.latlng.lat,e.latlng.lng,latfuego,longfuego)){
                            latfuego = $scope.json[i].latf;
                            longfuego = $scope.json[i].longf;
                            latagua = $scope.json[i].lata;
                            longagua = $scope.json[i].longa;
                        }
                    }
                    mymap.removeLayer(water);
                    water = L.circle([latagua, longagua],{radius: 800}).addTo(mymap).bindPopup("I'm a deep water deposit.");

                    if (state == 0) {
                        state = 1;
                        console.log("Estoy en circle");
                        latDestino = e.latlng.lat;
                        lngDestino = e.latlng.lng;
                    } else if (state == 1 ){
                        control.setWaypoints([]);
                        latDestino = e.latlng.lat;
                        lngDestino = e.latlng.lng;
                    } else {
                        control.setWaypoints([]);
                        latDestino = e.latlng.lat;
                        lngDestino = e.latlng.lng;
                        state = 1;
                    }
                })
            }
        });
        mymap.on('click', function (e) {
            if (state == 1){
                latOrigen = e.latlng.lat;
                lngOrigen = e.latlng.lng;
                control.setWaypoints([L.latLng(latOrigen, lngOrigen),
                    L.latLng(latDestino, lngDestino)]);
            } else if (state == 2) {
                console.log("Entro a borrar");
                control.setWaypoints([]);
                state = 0;
            }
        });
    }]);
