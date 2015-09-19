'use strict';

var app = angular.module('app', ['ngRoute']);
app.config(['$routeProvider', '$locationProvider', function ($routeProvider, $locationProvider) {  
    $routeProvider
        .when('/admin/home', {
            templateUrl: 'admin/home'
        })  
        .otherwise({  
            redirectTo: '/admin/home'
        });
    
    $locationProvider.html5Mode(true);
}]);  