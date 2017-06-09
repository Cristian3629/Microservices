var careerActions = ["Mostrar carreras","Agregar carrera","Eliminar Carrera"]
var subjectActions = ["Mostrar cursos de Materia","Eliminar Materia","Agregar Materia"];
var courseActions = ["Agregar Curso","Eliminar Curso","Mostrar cursos"]
var studentActions = ["Agregar Alumno","Eliminar Alumno","Actualizar Información","Inscribir a Materia","Mostrar alumnos","Inscribir a Carrera"];
var currentAction = null;
var currentObject = null;
var selectedValue = null;

// <input type="text" name="fname"><br>

var action;
var object;
//Algunas acciones requieren que el usuario cargue en un formulario
//algunas datos para poder realizar el request, para eso necesito saber si para
//el request que me piden, necesito información extra, osea si se tuve que
//mostrar el formulario, seguro son parametros para el request
var seCargoFormulario = true;

$(document).ready(function(){

  $('#action').click(function(){
    cleanPage();
    console.log("Click action");
    cleanPage();
    var currentValue = this.value;
    console.log("current value:"+currentValue);
    switch (currentValue) {
      case "Agregar Alumno":
        addInpuToFormWithField("Padrón");
        addInpuToFormWithField("Nombre");
        addInpuToFormWithField("Email");
        action = 'POST';
        object = 'students';
        break;
      case "Eliminar Alumno":
        accion = 'DELETE';
        object = 'students';
        addInpuToFormWithField("Id");
        addInpuToFormWithField("Nombre");
        break;
      case "Actualizar Información":
        accion = 'PUT';
        object = 'students';
        addInpuToFormWithField("Nombre");
        addInpuToFormWithField("Email");
        addInpuToFormWithField("Carrera");
        break;
      case "Inscribir a Materia":
        object = 'students';
        accion = 'PUT';
        addInpuToFormWithField("Padron");
        addInpuToFormWithField("Materia");
        addInpuToFormWithField("Cuatrimestre");
        break;
      case "Inscribir a Carrera":
        object = 'students';
        accion = 'PUT';
        addInpuToFormWithField("Padron");
        showCareers();
        break;
      case "Mostrar cursos de Materia":
        accion = 'GET';
        object = 'courses';
        addInpuToFormWithField("Numero");
        addInpuToFormWithField("Nombre");
        addInpuToFormWithField("Cuatrimestre");
        break;
      default:
        seCargoFormulario = false;
        break;
    }
    if (seCargoFormulario){
      showForm();
    }
  });



function showCareers(){
  action = 'GET';
  object = 'careers';
  params = '';
  makeRequest(action,object,params,showList);
}


  //Con esta funcion obtengo los parametros que fueron cargados en el form;
function getParams(){
  var cadenaSalida = "";
  var inputs = $('input.myInput');
    for (var i = 0; i < inputs.length-1; i++) {
      var input = inputs[i];
      var valor = $(input).val();
      var name = $(input).attr('name');
      console.log('valor:'+valor+'name:'+name);
      cadenaSalida = cadenaSalida + name + "=" + valor+"&";
    }
  var input = inputs[inputs.length -1 ];
  var valor = $(input).val();
  var name = $(input).attr('name');
  console.log('valor:'+valor+'name:'+name);
  cadenaSalida = cadenaSalida + name + "=" + valor;
  console.log('params:'+cadenaSalida);
  return cadenaSalida;
}




  //Enviar equivale a realizar la accion
  $("#enviar").click(function(){
    var params = ''
    var currentValue = $("#action").val();
    console.log("La accion que quiere realizar es:"+currentValue);
    if (currentValue == courseActions[2]){
      action = 'GET';
      object = 'courses';
    }
    if (currentValue == subjectActions[0]){
      loadBDDFromObject("subjects");
      action = 'GET';
      object = 'subjects';
    }
    if (currentValue == studentActions[4]){
      action = 'GET';
      object = 'students';
    }
    if (seCargoFormulario){
      params = getParams();
    }
    console.log('makeRequest('+action+','+object+','+params+');')
    makeRequest(action,object,params);
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


function cleanPage(){
  hideTable();
  cleanTable();
  cleanForm();
}

function addInpuToFormWithField(field){
  $('#form').append(field+":");
  $('#form').append('<br>');
  var form = $(document.createElement('input'));
  form.attr('type','text');
  form.attr('name',field.toLowerCase());
  form.addClass('myInput');
  $('form').append(form);
  $('#form').append('<br>');
}



function cleanTable(){
  $(".myTableRow").remove();
}

function hideTable(){
  $("table").hide();
}

function hideForm(){
  $("form").hide();
}

function cleanForm(){
  $('.myInput').remove();
  $('form').text('');
}
function showForm(){
  $('form').show();
}
