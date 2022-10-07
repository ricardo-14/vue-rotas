<template>
  <div>
    <h1>Carros</h1>
    <button @click="novo()">Novo</button>
    <table>
        <tr>
            <th>Id</th>
            <th>Nome</th>
            <th>Ano fabricação</th>
            <th>Ano modelo</th>
            <th>Preço</th>
            <th>Marca</th>
            <th>Cor</th>
        </tr>
        <tr v-for="c in carros" :key="c.id">
            <td>{{c.id}}</td>
            <td>{{c.nome}}</td>
            <td>{{c.anoFabricacao}}</td>
            <td>{{c.anoModelo}}</td>
            <td>{{c.preco}}</td>
            <td>{{c.marca}}</td>
            <td>{{c.cor}}</td>
        </tr>
    </table>
  </div>
</template>

<script>
import axios from 'axios'
export default {
    data() {
        return {
            carros: []
        }
    },
    methods: {
        load() {
            axios
            .get('https://carros-app-example.herokuapp.com/carro')
            .then(resp => {
                this.carros = resp.data
            })
        }
    },
    mounted() {
        this.load()
    }
}
</script>

<style>

</style>