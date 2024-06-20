<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Http;

class ConsumirController extends Controller
{
    public function index(){
        $response = Http::get('http://localhost/ServiciosAD/Escritorio/select.php');
       $data = $response->json();
       return view('inicio',compact('data'));
       

    }
    public function indice(){
        $response = Http::get('http://localhost/ServiciosAD/Escritorio/select1.php');
        $data = $response->json();
        return view('inicio1',compact('data'));
    }
    public function lugar(){
        $response = Http::get('http://localhost/ServiciosAD/Escritorio/select2.php');
        $data = $response->json();
        return view('lugar',compact('data'));
    }

    public function create(){
        return view('guardar');
    }


    public function store(Request $request){
        
        $response = Http::asForm()->post('http://localhost/ServiciosAD/Escritorio/guardar.php',
         [
            'tax_cooperativa'  =>  $request->coop,
            'tax_nombre' => $request->nombre,
            'tax_apellido' => $request->apellido,
            'tax_estado' => $request->estado,
           
        ]);

        return redirect()->route('pag.indice');
    }

    public function delete($cedula){
        $response = Http::asForm()->post('http://localhost/ServiciosAD/Escritorio/eliminar.php',
        [
           'tax_cooperativa'  =>  $cedula,
       ]);
       return redirect()->route('pag.indice');
    }

    public function createup($coop){
        return view('editar',compact('coop'));
    }

    public function update(Request $request){
        
        $response = Http::asForm()->post('http://localhost/ServiciosAD/Escritorio/editar.php',
         [
            'tax_cooperativa'  =>  $request->coop,
            
            'tax_estado' => $request->estado,
            'cli_cedula'=> $request->cliente,
           
        ]);
        return redirect()->route('pag.indice');
    }

}
