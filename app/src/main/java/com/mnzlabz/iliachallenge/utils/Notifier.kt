package com.mnzlabz.iliachallenge.utils

import android.content.Context
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.mnzlabz.iliachallenge.R

class Notifier {

    companion object {
        fun notify(message: String, context: Context) {
            MaterialAlertDialogBuilder(context)
                .setTitle(message)
                .setPositiveButton(context.getString(R.string.ok)) { dialog, which ->
                    dialog.dismiss()
                }
                .show()
        }
    }
}