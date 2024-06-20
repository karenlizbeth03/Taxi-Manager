package com.example.login_php;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class Cliente {
    private String calle1;
    private String calle2;
    private String referencia;
    private String barrio;
    private String info;

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente=cliente;
    }

    private String cliente;

    public Cliente(){

    }
    public static ArrayList<Cliente> getClienteFromJson(JSONArray jsonArray, Context context) {
        ArrayList<Cliente> clientes = new ArrayList<>(jsonArray.length());
        try{
            for (int i = 0; i < jsonArray.length(); i++) {
                clientes.add(jsonToClientes(jsonArray.getJSONObject(i),context));
            }
        }catch(Exception e){
            e.printStackTrace();

        }


        return clientes;
    }

    private static Cliente jsonToClientes(JSONObject jsonObject, Context context) {
        Cliente cliente=new Cliente();
        try{
            cliente.setCalle1(jsonObject.getString("calle1"));
            cliente.setCalle2(jsonObject.getString("calle2"));
            cliente.setReferencia(jsonObject.getString("referencia"));
            cliente.setBarrio(jsonObject.getString("barrio"));
            cliente.setInfo(jsonObject.getString("info"));
            cliente.setCliente(jsonObject.getString("cli_cedula"));

        }catch(Exception ex){
            ex.printStackTrace();
        }
        return cliente;
    }

    public String getCalle1() {
        return calle1;
    }

    public void setCalle1(String calle1) {
        this.calle1=calle1;
    }

    public String getCalle2() {
        return calle2;
    }

    public void setCalle2(String calle2) {
        this.calle2=calle2;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia=referencia;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio=barrio;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info=info;
    }



}
