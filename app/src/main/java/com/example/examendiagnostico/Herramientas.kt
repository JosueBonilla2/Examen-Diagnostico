package com.example.examendiagnostico

import android.os.Parcel
import android.os.Parcelable

data class Herramientas(
    var herramienta: String,
    var tipo: String,
    var tamano: Int,
    var codigo: Int,
    var precio: Float
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readInt(),
        parcel.readFloat()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(herramienta)
        parcel.writeString(tipo)
        parcel.writeInt(tamano)
        parcel.writeInt(codigo)
        parcel.writeFloat(precio)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Herramientas> {
        override fun createFromParcel(parcel: Parcel): Herramientas {
            return Herramientas(parcel)
        }

        override fun newArray(size: Int): Array<Herramientas?> {
            return arrayOfNulls(size)
        }
    }
}
