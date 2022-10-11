<template>
<div>
    <h1>Marcas</h1>
   <DataTable :value="marcas">
        <Column field="id" header="ID"></Column>
        <Column field="nome" header="Nome"></Column>
        <Column headerStyle="width: 4rem; text-align: center" bodyStyle="text-align: center; overflow: visible">
            <template #body="{data}">
                <Button type="button" icon="pi pi-pencil" class="p-button-warning" @click="editar(data)" />
            </template>
        </Column>
        <Column headerStyle="width: 4rem; text-align: center" bodyStyle="text-align: center; overflow: visible">
            <template #body="{data}">
                <Button type="button" icon="pi pi-trash" class="p-button-danger" @click="excluir(data)"></Button>
            </template>
        </Column>  
    </DataTable>
    <br>
    <Button class="button-marca p-button-success" label="Nova marca" icon="pi pi-plus"  iconPos="left" @click="novo()"/>
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
            const id = marca.id
            this.$router.push(`/marca-form/${id}`)
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