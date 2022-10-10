<template>
<div>
    <h1>Marcas</h1>
   <DataTable :value="marcas">
        <Column field="id" header="ID"></Column>
        <Column field="nome" header="Nome"><a href="javascript:void(0)" @click="editar(m)">Editar</a></Column>
        <Column></Column>   
    </DataTable>
    <br>
    <Button class="button-marca" label="Nova marca" icon="pi pi-plus" iconPos="left" @click="novo()"/>
</div>
<br>
    <div>
    <table>
        <tr>
            <th>Id</th>
            <th>Nome</th>
            <th></th>
            <th></th>
        </tr>
        <tr v-for="m in marcas" :key="m.id">
            <td>{{m.id}}</td>
            <td>{{m.nome}}</td>
            <td><a href="javascript:void(0)" @click="editar(m)">Editar</a></td>
            <td><a href="javascript:void(0)" @click="excluir(m)">Excluir</a></td>
        </tr>
    </table>
</div>
</template>

<script>
import axios from 'axios'
export default {
    data() {
        return {
            marcas: []
        }
    },
    methods: {
        editar(marca) {
            this.$router.push(`/marca-form/${marca.id}`)
        },
        novo() {
            this.$router.push('/marca-form/')
        },
        excluir(marca) {
            const id = marca.id
            axios
                .delete(`https://carros-app-example.herokuapp.com/marca/${id}`)
                .then(this.load())
                .catch(error => alert(error))
        },
        load() {
            axios
            .get('https://carros-app-example.herokuapp.com/marca')
            .then(resp => {
                this.marcas = resp.data
            })
        }
    },
    mounted() {
        this.load()
    }
}
</script>

<style>
.button-marca {
    float: right;
}
</style>