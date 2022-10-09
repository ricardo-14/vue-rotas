<template>
  <div>
    <h1>Cadastro de Carros</h1>
    <form @submit.prevent="salvar()">
        <span v-if="mensagem">{{mensagem}}<br></span>
        <label for="nome">Nome:</label>
        <input type="text" size="40" required v-model="carro.nome">
        <br>
        <label for="anoFabricacao">Ano fabricação:</label>
        <input type="date" required v-model="carro.anoFabricacao">
        <br>
        <label for="anoModelo">Ano modelo:</label>
        <input type="date" required v-model="carro.anoModelo">
        <br>
        <label for="preco">Preço:</label>
        <input type="number" required v-model="carro.preco">
        <br>
        <label for="marca">Marca:</label>
        <select name="marca" v-model="carro.marca"></select>
        <br>
        <input type="submit" value="Salvar"/> 
        <a href="javascript:void(0)" @click="voltar()">Voltar</a>
    </form>
  </div>
</template>

<script>
import axios from 'axios'
export default {
    data() {
        return {
            carro: {
                nome: ''    
            },
            mensagem: null
        }
    }
}
</script>

<style>

</style>