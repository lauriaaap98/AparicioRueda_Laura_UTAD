package com.example.actividad2u2

class Tecnologia(val titulo: String, val fecha: String, val imagen: Int) {
    fun toNew(): New {
        return New(titulo, fecha, imagen)
    }
}