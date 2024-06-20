<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Estudiante extends Model
{
    public $timestamps = false;
    protected $primaryKey = 'cli_cedula';
    protected $fillable = ['cli_cedula','cli_nombre','cli_apellido','cli_telefono'];
}
