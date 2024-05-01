package com.maxim.qrscanner.qr.presentation

import android.graphics.Bitmap
import android.graphics.Color
import android.widget.ImageView
import android.widget.TextView
import com.google.zxing.BarcodeFormat
import com.google.zxing.qrcode.QRCodeWriter

interface QrState {
    fun show(resultTextView: TextView, qrImageView: ImageView)

    object Initial: QrState{
        override fun show(resultTextView: TextView, qrImageView: ImageView) {
            qrImageView.setImageBitmap(null)
            resultTextView.text = ""
        }
    }

    class Base(private val text: String): QrState {
        override fun show(resultTextView: TextView, qrImageView: ImageView) {
            resultTextView.text = text
            val writer = QRCodeWriter()
            val matrix = writer.encode(text, BarcodeFormat.QR_CODE, 512, 512)
            val bitmap = Bitmap.createBitmap(matrix.width, matrix.height, Bitmap.Config.RGB_565)
            for (x in 0..<matrix.width) {
                for (y in 0..<matrix.height) {
                    bitmap.setPixel(x, y, if (matrix[x, y]) Color.BLACK else Color.WHITE)
                }
            }
            qrImageView.setImageBitmap(bitmap)
        }
    }
}