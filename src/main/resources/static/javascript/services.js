angular.module('appFire')

    .factory('app', function ($state, $http, $httpParamSerializer) {
        return {
            //send the register info to the server
            getFires: function (callbackSuccess) {
                $http({
                    method: 'GET',
                    url: '/fires',
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded'
                    }
                }).success(function (data) {
                    callbackSuccess(data);
                });
            },

            getWater: function (lat, lng, callbackSuccess) {
                console.log(lat + " "+ lng);
                $http({
                    method: 'GET',
                    url: '/water',
                    headers: {
                        'Content-Type': 'application/x-www-form-urlencoded',
                        'lat': lat,
                        'lng': lng
                    }
                }).success(function (data) {
                    callbackSuccess(data);
                });
            }
        };
    });

