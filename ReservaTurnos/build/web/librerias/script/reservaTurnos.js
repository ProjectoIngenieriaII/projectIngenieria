var lang_dataTable = {
	"sLengthMenu": "Mostrar _MENU_ Registros",
	"sZeroRecords": "No se encontraron resultados",
	"sEmptyTable": "Ningún dato disponible en esta tabla",
	"sInfo": "Mostrando _START_ a _END_ de _TOTAL_ Registro(s)",
	"sInfoEmpty": "",
	"sInfoFiltered": "(filtrado de un total de _MAX_ registros)",
	"sInfoPostFix": "",
	"sSearch": "Filtro:",
	"sUrl": "",
	"sInfoThousands": ",",
	"sLoadingRecords": "Cargando...",
	"oPaginate": {
	  "sFirst": "Primero",
	  "sLast": "Final",
	  "sNext": "Siguiente",
	  "sPrevious": "Anterior"
	},
	"select" : {"rows": "%d fila(s) seleccionada(s)"},
	"oAria": {
	"sSortAscending": ": Activar para ordenar la columna de manera ascendente",
	"sSortDescending": ": Activar para ordenar la columna de manera descendente"
	}
};

function ajaxJson(ruta,data,type = 'post'){
    return $.ajax({
        url: ruta,
        type: type,
        data: data,
    });
}

var _Reserva = (function (){
})(jQuery);

$(document).ready(function(){
});