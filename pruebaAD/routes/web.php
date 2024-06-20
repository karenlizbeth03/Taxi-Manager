<?php

use Illuminate\Support\Facades\Route;
use Illuminate\Support\Facades\Http;
use App\Http\Controllers\ConsumirController;

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

/*Route::get('/', function () {
    return view('welcome');
});*/

Route::get('/', [ConsumirController::class, 'index'])->name('pag.index');
Route::get('/indice', [ConsumirController::class, 'indice'])->name('pag.indice');
Route::get('/lugar', [ConsumirController::class, 'lugar'])->name('pag.lugar');
Route::get('/guardar', [ConsumirController::class, 'create'])->name('pag.guardar');
Route::post('/guardar',[ConsumirController::class, 'store'])->name('pag.store');
Route::get('/eliminar/{tax_cooperativa}',[ConsumirController::class, 'delete'])->name('pag.delete');
Route::get('/editar/{tax_cooperativa}',[ConsumirController::class, 'createup'])->name('pag.update');
Route::post('/editar',[ConsumirController::class, 'update'])->name('pag.updateService');