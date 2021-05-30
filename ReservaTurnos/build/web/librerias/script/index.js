var _Index = (function (){

    var ruta = 'Usuario';

    var AddUser = ()=>{
        $('#addResgistroUser').modal('show');
    }
    
    var ingresar = ()=>{
        data = {
            'metodo':'verificarUsuario',
            'txtUsuario':$('#txtUsuario').val(),
            'txtPassword':$('#txtPassword').val()
        };
        var type = 'POST';
        $.when(ajaxJson(ruta,data,type)).done((resp)=>{
            resp = JSON.parse(resp.replace('\r\n',''));
            if(resp[0].resp){
                location.href = "User/?user="+resp[1].user;
            }else{
                alert('Usuario o contraseña incorrecto.');
            }
        });
    }
    
    return {
        AddUser:AddUser,
        ingresar:ingresar
    }
})(jQuery);
$(document).ready(function(){
    $("#formLogin").submit(function(event){
        event.preventDefault();
        _Index.ingresar();
    });
});