var http = require('http');

/**
 * Carga de los parámetros genéricos del servicio RESTful
 */
var host = 'localhost';
var port = '4567';

/**
 * Función encargada de recuperar todos los usuarios.
 */
exports.loadUsers = function(next) {
    var path = '/users';

    var options = {
        host: host,
        port: port,
        path: path,
        method: 'GET',
        encoding: null
    };

    // Se invoca el servicio RESTful con las opciones configuradas previamente y sin objeto JSON.
    invocarServicio(options, null, function (users, err) {
        if (err) {
            next(null, err);
        } else {
            next(users, null);
        }
    });
};
