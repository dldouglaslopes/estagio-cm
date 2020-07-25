jQuery(document).ready(function(){

    jQuery("#btn_vai").click(function(){

        var url = '/estagio-cm/greeting';
        jQuery.ajax({
            url: url,
            type: 'GET',
            data: 'estagiario.nome='+jQuery("#nome").val(),
            dataType: "json",
            success: function (data, textStatus, jqXHR) {
                jQuery("#resposta").append("Bem vindo, " + data.estagiario.nome + "! Tá salvo!");
            }
        }); 
    });
    
    jQuery("#pesquisar").click(function(){

    	var url = '/estagio-cm/pesquisar';      
    	jQuery.ajax({
            url: url,
            type: 'GET',
            data: 'usuario.nome=doug',
            dataType: "json",
            success: function (data, textStatus, jqXHR) {
               
            }
        }); 
    });
});