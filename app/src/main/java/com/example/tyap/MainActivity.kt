package com.example.tyap

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

	var edit1: EditText? = null
	var edit2: EditText? = null
	var text1: TextView? = null
	var text2: TextView? = null
	var text3: TextView? = null
	var but2: Button? = null

	var n: Int = 0
	var k: Int = 0
	var i: Int = -1
	var end: Int = 0
	var chasiki: Int = 0

	var arr: Array<Array<Int>> = arrayOf()
	var alphabet: Array<String> = arrayOf()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		val but1: Button = findViewById(R.id.but1)
		but2 = findViewById(R.id.but2)
		but2?.isVisible = false
		edit1 = findViewById(R.id.edit1)
		edit2 = findViewById(R.id.edit2)

		text1 = findViewById(R.id.text1)
		text2 = findViewById(R.id.text2)
		text3 = findViewById(R.id.text3)

		but1.setOnClickListener {
			when (chasiki) {
				0 -> f1()
				1 -> f2()
				2 -> f3()
				3 -> f4()
			}
			edit1?.setText("")
		}
		but2?.setOnClickListener {
			text1?.text = "Количествс правил:"
			text2?.isVisible = true
			edit2?.isVisible = true
			edit2?.setText("")
			but2?.isVisible = false
			chasiki = 0
			i=-1
		}
	}

	fun f4() {
		val stroka = edit1?.text.toString()
		var symbol = 0
		var p: Int
		var ok = true
		text3?.text = ""
		for (g in stroka){
			ok = false
			for (h in alphabet) {
				if (h == g.toString()) {
					ok = true
				}
			}
			if(!ok) break
		}
		if(ok){
			for (g in stroka) {
				p = 0
				for (h in alphabet) {
					if (h == g.toString()) {
						symbol = arr[symbol][p]
					}
					p++
				}
				if (symbol == -1) {
					break
				}
			}
			if (symbol == -1) text3?.text = "Такого пути нет"
			else if (symbol != end) text3?.text = "Кем я стал?"
			else text3?.text = "Всё отлично"
		}
		else text3?.text = "Нет такой буквы"
	}

	fun f3() {
		end = edit1?.text.toString().toInt()
		text1?.setText("Введите строку")
		but2?.isVisible = true
		chasiki = 3
	}

	fun f2() {
		val stroka = edit1?.text.toString()
		var p: Int = 0
		for (g in stroka) {
			if (i == -1) {
				alphabet[p] = g.toString()
			} else {
				if (g == '-') arr[i][p] = -1
				else arr[i][p] = g.code - 48
				text3?.text = arr[i][p].toString()
			}
			p++
		}
		text1?.setText("Введите пути")
		i++
		if (i == n) {
			chasiki = 2
			text1?.text = "Введите индекс конечного состояния"
		}
	}

	fun f1() {
		n = edit1?.text.toString().toInt()
		k = edit2?.text.toString().toInt()
		arr = Array(n, { Array(k, { 0 }) })
		alphabet = Array(k, { "" })
		text1?.setText("Введите алфавит")
		text2?.isVisible = false
		edit2?.isVisible = false
		chasiki = 1
	}

}