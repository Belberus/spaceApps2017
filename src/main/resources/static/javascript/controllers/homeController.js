angular.module('appFire')

    .controller('homeCtrl', ['$scope', '$state', 'app', function ($scope, $state, app) {

        $scope.json = "";

        $scope.getFires = function(){
            app.getFires(function(data){
                $scope.json = data;
            });
        }
    }]);
