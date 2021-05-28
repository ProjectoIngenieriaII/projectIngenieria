var _IndexUser = (function (){
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
        "<button class='btn btn-sm btn-danger'>Eliminar</button><button class='btn btn-sm btn-primary'>Editar</button>",
        "Bogotá DC",
        "Bogotá",
        "Norte",
        "Lavado",
        "2011/04/25"
    ],
    [
        "<button class='btn btn-sm btn-danger'>Eliminar</button><button class='btn btn-sm btn-primary'>Editar</button>",
        "Bogotá DC",
        "Bogotá",
        "Norte",
        "Encerado",
        "2015/04/20"
    ],
    [
        "<button class='btn btn-sm btn-danger'>Eliminar</button><button class='btn btn-sm btn-primary'>Editar</button>",
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
    
    return {
        AddReserva:AddReserva
    }

})(jQuery);
$(document).ready(function(){
});