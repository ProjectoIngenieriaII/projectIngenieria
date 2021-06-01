var _IndexUser = (function (){
    var ruta = '../Departamento';
    var TablesReserva;
    _columnsReserva = [
        {"width": "1%"},
        {"width": "15%"},
        {"width": "15%"},
        {"width": "15%"},
        {"width": "15%"},
        {"width": "15%"}
    ];
    
    var data = [[
        "<button class='btn btn-sm btn-danger' id='eliminarElemento'>Eliminar</button>",
        "Bogotá DC",
        "Bogotá",
        "Norte",
        "Lavado",
        "2011/04/25"
    ],
    [
        "<button class='btn btn-sm btn-danger'>Eliminar</button>",
        "Bogotá DC",
        "Bogotá",
        "Norte",
        "Encerado",
        "2015/04/20"
    ],
    [
        "<button class='btn btn-sm btn-danger'>Eliminar</button>",
        "Bogotá DC",
        "Bogotá",
        "Norte",
        "Pinta",
        "2013/04/20"
    ]];

    TablesReserva = $("#tableReservas").DataTable({
        pagingType: "numbers",
        language: lang_dataTable,
        autoWidth: false,
        searching: true,
        ordering: true,
        paging: true,
        destroy: true,
        pageLength: 10,
        columns: _columnsReserva,
        order: [[0, 'asc']],
        data: data
    });
    
    var AddReserva = ()=>{
        $('#modalAddReserva').modal('show');
    }
    
    var init = ()=>{
        listarDepto();
    }
    
    var listarDepto = ()=>{
        data = {
            'metodo':'listarData',
        };
        var type = 'POST';
        $.when(ajaxJson(ruta,data,type)).done((resp)=>{
            resp = JSON.parse(resp.replace('\r\n',''));
            if(resp.resp){
                $('#slcDepto').append('<option value="">Seleccionar...</option>');
                // Listar los departamentos
                $.each(resp.data,(i,e)=>{
                    $('#slcDepto').append('<option value="'+e.id_depto+'">'+e.nom_depto+'</option>');
                });
            }
        });
    }
    
    var listarCiudades = ()=>{
        data = {
            'metodo': 'listarCiudad',
            'depto' : $('#slcDepto').val()
        }
        var type = 'POST';
        var ruta = '../Ciudad';
        $.when(ajaxJson(ruta,data,type)).done((resp)=>{
            $('#slcCiudad').html('');
            resp = JSON.parse(resp.replace('\r\n',''));
            if(resp.resp){
                $('#slcCiudad').append('<option value="">Seleccionar...</option>');
                // Listar los departamentos
                $.each(resp.data,(i,e)=>{
                    $('#slcCiudad').append('<option value="'+e.id_ciudad+'">'+e.nom_ciudad+'</option>');
                });
            }
        });
    }
    
    return {
        init:init,
        AddReserva:AddReserva,
        listarCiudades:listarCiudades
    }

})(jQuery);
$(document).ready(function(){
    _IndexUser.init();
    
    $('#slcDepto').on('change',()=>{
       _IndexUser.listarCiudades();
    });
    
    $('#userData').val(window.location.search.replace('?user=',''));
});