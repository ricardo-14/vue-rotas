<template>
 <div>
   <DataTable :value="carros" responsiveLayout="scroll">
        <template #header>
                <div class="table-header">
                    <h1>Carros</h1>
                        <Button class="p-button-success" label="Novo carro" icon="pi pi-plus" iconPos="left" @click="novo()"/>
                        <Button icon="pi pi-refresh" @Click="reload()"/>
                </div>
        </template>
        <Column field="id" header="ID" :sortable="true"></Column>
        <Column field="nome" header="Nome" :sortable="true"></Column>
        <Column field="anoFabricacao" header="Ano fabricação" :sortable="true"></Column>
        <Column field="anoModelo" header="Ano modelo" :sortable="true"></Column>
        <Column field="preco" header="Preço" :sortable="true"></Column>
        <Column field="marca.nome" header="Marca" :sortable="true"></Column>
        <Column field="cor.nome" header="Cor" :sortable="true"></Column>

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
            Total de carros cadastrados: {{carros ? carros.length : 0 }}
        </template>   
    </DataTable>
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
            .get('http://localhost:8080/carro')
            .then(resp => {
                this.carros = resp.data
            })
        },
        novo() {
            this.$router.push('/carro-form/')
        },
        excluir(carro) {
            const id = carro.id
            axios
                .delete(`http://localhost:8080/carro/${id}`)
                .then(this.load())
                .catch(error => alert(error))
        },
        editar(carro) {
            this.$router.push(`/carro-form/${carro.id}`)
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