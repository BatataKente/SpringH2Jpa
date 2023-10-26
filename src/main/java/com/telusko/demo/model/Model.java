package com.telusko.demo.model;

import com.google.gson.Gson;

abstract class Model {
	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
}
