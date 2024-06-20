<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ProyectoAD</title>
        <style>
        body{
         background: url("https://previews.123rf.com/images/mousemd/mousemd1703/mousemd170300066/73964895-fondo-de-patr%C3%B3n-de-servicios-de-taxi-vector.jpg");
         background-repeat: no-repeat;
         background-size: 100vw 100vh;
        }
        </style>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        
    </head>
    <body >
    
        <div class="container"> 
           <center><h1 style="color:#FFFF">Clientes</h1> </center>
           <div class="card">
               <div class="card-header">
                   <a href="{{ route('pag.indice') }}" class="btn btn-primary">Taxis Disponibles</a><br>
                   <a href="{{ route('pag.lugar') }}" class="btn btn-warning">Lugares</a><br><br>
               </div>
               <div class="card-body">
                   <table class="table table-hover">
                       <thead>
                           <tr>
                               <th>Cedula</th>
                               <th>Nombre</th>
                               <th>Apellido</th>
                               <th>Telefono</th>
                              
                           </tr>
                       </thead>
                       <tbody>
                        
                          <?php 
                        if (is_array($data)){

                          foreach($data as $est){?>
                           <tr>
                               <td><?php echo $est['cli_cedula'] ?></td>
                               <td><?php echo $est['cli_nombre'] ?></td>
                               <td><?php echo $est['cli_apellido'] ?></td>
                               <td><?php echo $est['cli_telefono'] ?></td>
                                
                           </tr>
                           <?php
                          }
                        }
                           ?>
                       </tbody>
                   </table>
                   
               </div>
           </div>
        </div>
        
    </body>
</html>
