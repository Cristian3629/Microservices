var careerActions = ["Mostrar carreras","Agregar carrera","Eliminar Carrera"]
var subjectActions = ["Mostrar materias","Elegir materia","Eliminar Materia","Agregar Materia"];
var courseActions = ["Agregar Curso","Eliminar Curso"]
var studentActions = ["Agregar Alumno","Eliminar Alumno","Actualizar Información","Inscribir"];
var currentAction = null;
var currentObject = null;
var selectedValue = null;


$(document).ready(function(){

  $("#action").click(function(){
    var currentValue = this.value;
    console.log("La accion que quiere realizar es:"+currentValue);
    if (currentValue == "Mostrar materias"){
      console.log("Preparo request para mostrar materias");
      var xmlHttp = new XMLHttpRequest();
      xmlHttp.open('GET', "http://localhost:4567/courses",false); // false for synchronous request
      xmlHttp.send();
      console.log(xmlHttp.responseText);
      var parse = JSON.parse(xmlHttp.responseText);
      var jsonObj = parse[0];
      var keys = Object.keys(jsonObj);
      console.log(Object.keys(jsonObj));
      var firstRow = $(document.createElement('tr'));
      for (var i = 0; i < keys.length; i++) {
        var column = $(document.createElement('th'));
        column.text(keys[i]);
        firstRow.append(column);
      }
      $("table").append(firstRow);
      for (var i in parse) {
        console.log("Parse{i}: "+parse[i]);
      }
      $("table").show();
    }
  });


  $("#object").click(function(){
    console.log("Hicieron un click");
    var currentValue = this.value;
    if (selectedValue != currentValue){
      console.log("value:"+currentValue);
      var selectActions;
      if (currentValue == "subject"){
        selectActions = subjectActions;
      }
      if(currentValue == "student"){
        selectActions = studentActions;
      }
      if(currentValue == "career"){
        selectActions = careerActions;
      }
      if(currentValue == "course"){
        selectActions = courseActions;
      }
      $("#action")
      .find('option')
      .remove()
      .end();

      for (var i in selectActions) {
         console.log(selectActions[i]);
         $("#action")
         .append('<option>' +selectActions[i]+'</option')
         .val(selectActions[i]);
       }
      selectedValue = currentValue;
    }
  });
});
