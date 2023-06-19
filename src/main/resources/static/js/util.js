function showPIIDoc()
{
    console.log("Entramos en la función")
    var x = document.getElementById("foto").value;
    console.log("valor de la url :" +  x)
    document.getElementById("imagen").src = x;
}

function eligeFoto(f) {
    file = f.files[0];
    reader = new FileReader();
    reader.onload = function(e) {
        $("#imagen").attr('src', e.target.result);
    }
    reader.readAsDataURL(file);
}
