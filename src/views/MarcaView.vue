<template>
<div>
   <DataTable :value="marcas" responsiveLayout="scroll">
        <template #header>
                <div class="table-header">
                    <h1>Marcas</h1>
                        <Button class="p-button-success" label="Nova marca" icon="pi pi-plus" iconPos="left" @click="novo()"/>
                        <Button icon="pi pi-refresh" @Click="reload()"/>
                </div>
        </template>
        <Column field="id" header="ID" :sortable="true"></Column>
        <Column field="nome" header="Nome" :sortable="true"></Column>
        <Column headerStyle="width: 4rem; text-align: center" bodyStyle="text-align: center; overflow: visible">
            <template #body="{data}">
                <Button type="button" icon="pi pi-pencil" class="p-button-warning" @click="editar(data)"/>
            </template>
        </Column>
        <Column headerStyle="width: 4rem; text-align: center" bodyStyle="text-align: center; overflow: visible">
            <template #body="{data}">
                <Button type="button" icon="pi pi-trash" class="p-button-danger" @click="excluir(data)"></Button>
            </template>
        </Column>
        <template #footer>
            Total de marcas cadastradas: {{marcas ? marcas.length : 0 }}
        </template>   
    </DataTable>
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
        },
        reload() {
            location.reload()
        }
    },
    mounted() {
        this.load()
    }
}
</script>

<style>

.table-header {
    display: flex;
    align-items: center;
    justify-content: space-between;
}

</style>