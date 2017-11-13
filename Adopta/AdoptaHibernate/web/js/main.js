
function sendData2Back(elemento){
    var id = elemento.id;
    var clase = elemento.className;
    
    console.log(id);
    console.log(clase);
    
    $.post("RegistraClick",
    {
        id: id,
        clase: clase
    }
    
    ,
    function(data){
        if(data.resultado === true){
           
        }  
        else{
            
        }
    }
    );
}


