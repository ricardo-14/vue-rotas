<template>
  <div>
    <h1>Carros</h1>
    <DataTable :value="carros">
        <Column field="id" header="ID"></Column>
        <Column field="nome" header="Nome"></Column>
        <Column field="anoFabricacao" header="Ano fabricação"></Column>
        <Column field="anoModelo" header="Ano modelo"></Column>
        <Column field="preco" header="Preço"></Column>
        <Column field="marca.nome" header="Marca"></Column>
        <Column field="cor.nome" header="Cor"></Column>
    </DataTable>
    <br>
    <Button class="button-carro" label="Novo carro" icon="pi pi-plus" iconPos="left" @click="novo()"/>
  </div><br>
  
  <div>
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
            <td><span v-if="c.marca">{{c.marca.nome}}</span></td>
            <td><span v-if="c.cor">{{c.cor.nome}}</span></td>
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
        },
        novo() {
            this.$router.push('/carro-form/')
        }
    },
    mounted() {
        this.load()
    }
}
</script>

<style>
    .button-carro {
    float: right;
}
</style>