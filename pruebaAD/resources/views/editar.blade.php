<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ProyectoAD</title>
        <style>
        body{
         background: url("https://i.pinimg.com/474x/ff/68/25/ff682528e339c2fe369a9e49d4e8b7e5.jpg");
         background-repeat: no-repeat;
         background-size: 100vw 100vh;
        }
        </style>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>
        <div class="container"> 
           <div class="card">
               <div class="card-header">
                   <h3>Editar Taxis</h3>
               </div>
               <div class="card-body">
                   <form action="{{ route('pag.updateService') }}" method="POST">
                    @csrf
                    
                       <label>Cooperativa</label>
                       <input type="text" name="coop" class="form-control" placeholder="coop" value= <?php echo($coop) ?>  >
                       <!-- <label>Nombre</label>
                       <input type="text" name="nombre" class="form-control" placeholder="nombre" >
                       <label>Apellido</label>
                       <input type="text" name="apellido" class="form-control" placeholder="apellido"> -->
                       <label>Estado</label>
                       <input type="text" name="estado" class="form-control" placeholder="estado" >
                       <label>Cliente</label>
                       <input type="text" name="cliente" class="form-control" placeholder="cliente" >
                  
                       <input type="submit" name="accion" value="Guardar" class="btn btn-primary mt-4" >
                       <a href="{{ route('pag.indice') }}" class="btn btn-primary mt-4">Cancelar</a>
                   </form>

               </div>
           </div>
        </div>
    </body>
</html>