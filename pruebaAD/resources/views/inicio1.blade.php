
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
           <h1>Taxis Disponibles</h1> 
           <div class="card">
               <div class="card-header">
                   <a href="{{ route('pag.index') }}" class="btn btn-warning">Regresar</a><br><br>
                   
               </div> 
               <div class="card-body">
                   <table class="table table-hover">
                       <thead>
                           <tr>
                               <th>Cooperativa</th>
                               <th>Nombre</th>
                               <th>Apellido</th>
                               <th>Estado</th>
                               <th>Cliente</th>
                              
                           </tr>
                       </thead>
                       <tbody>
                        
                          <?php 
                        if (is_array($data)){

                          foreach($data as $tax){?>
                           <tr>
                               <td><?php echo $tax['tax_cooperativa'] ?></td>
                               <td><?php echo $tax['tax_nombre'] ?></td>
                               <td><?php echo $tax['tax_apellido'] ?></td>
                               <td><?php echo $tax['tax_estado'] ?></td>
                               <td><?php echo $tax['cli_cedula'] ?></td>
                               <td>
                                   <a href="{{ route('pag.update', $tax['tax_cooperativa']) }}" class="btn btn-primary">Asignar</a>
                                  <!--  <a href="{{ route('pag.delete', $tax['tax_cooperativa']) }}" class="btn btn-danger">Eliminar</a>
                               --> </td>
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
