function showPIIDoc()
{
    console.log("Entramos en la función")
    var x = document.getElementById("foto").value;
    console.log("valor de la url :" +  x)
    document.getElementById("imagen").src = x;
}
