var port = "4567";

//Aca van lo que seria como realizar un request y como muestro la respuesta


function makeRequest(action,object,params,funcion){
  var xmlHttp = new XMLHttpRequest();
  var path;
  if (params != ""){
  path = 'http://localhost:'+port+'/'+object+'?'+params;
  }else {
  path = 'http://localhost:'+port+'/'+object;
  }
  console.log('xmlHttp.open('+action +','+ path+')');
  xmlHttp.open(action,path,false);

  xmlHttp.onload = function () {
    if (xmlHttp.readyState === xmlHttp.DONE) {
        if (xmlHttp.status === 200) {
            console.log(xmlHttp.response);
            console.log(xmlHttp.responseText);
            console.log(xmlHttp.status);
            funcion(xmlHttp.responseText);
        }
    }
  };

  xmlHttp.send();
}



//Dado el JSONObject, me fijo si es un array o no.
function getArray(parse){
  var array;
  if (isArray(parse)){
    console.log('Es un array');
    array = parse;
  }else{
    console.log('No es un array');
    array = (new Array()).concat(parse);
  }
  return array;
}


//Dada la respuesta del request, lo convierton en JSON
function getJSON(response){
  console.log("response:"+response);
  console.log("showInformation");
  var responseString = String(response);
  // console.log("response type:"+jQuery.type(responseString));
  // console.log("response string:"+responseString.length);
   var parse = jQuery.parseJSON(responseString);
   console.log("parse:"+parse);
   return parse;
}

function showList(response){
  var parse = getJSON(response);
  var array = getArray(parse);

  for (var i = 0; i < array.length; i++) {
    var option = $(document.createElement('option'));
    var row = array[i]
    var value = row['codigo'];
    option.val(value);
    option.text(row['name'] + ' ' + row['plan']);
    $('#select').append(option);
  }

  $('#select').show();
}




function showInformation(response){
  var parse = getJSON(response);
  var array =  getArray(parse);
  console.log('Array:'+array);
  console.log('Array[0]:'+array[0]);
  var keys = Object.keys(array[0]);
  var firstRow = $(document.createElement('tr'));
  //inserto la primera fila con los nombres de la columna
  for (var i = 0; i < keys.length; i++) {
    var column = $(document.createElement('th'));
    console.log('keys[i]:'+keys[i]);
    column.text(keys[i]);
    $(column).css('border','none');
    firstRow.append(column);
  }
  $(firstRow).addClass("head");
  $(firstRow).css('background','gray');
  $(firstRow).css('color','white');
  $(firstRow).css('border','none');
  $("table").append(firstRow);
  console.log('array.length:'+ array.length);
  for (var i = 0; i < array.length; i++){
    console.log("entre en el for:"+i);
     if ( i > 40){
       console.log("corté");
       return 0;
     }
     var jsonRow = array[i];
     var row = $(document.createElement('tr'));
     for (var j in keys) {
       //creo la columna
       var column = $(document.createElement('td'));
       $(column).css('border','none');
       column.text(jsonRow[keys[j]]);
       $(row).append(column);
     }
     $(row).addClass("myTableRow");
     $("table").append(row);
   }
  $('table').css('border','none');
  $("table").show();
}

function isArray(what) {
    return Object.prototype.toString.call(what) === '[object Array]';
}
