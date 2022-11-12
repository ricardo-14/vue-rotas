<template>
  <div>
    <DataTable :value="cores" responsiveLayout="scroll">
      <template #header>
                <div class="table-header">
                    <h1>Cores</h1>
                        <Button class="p-button-success" label="Nova cor" icon="pi pi-plus" iconPos="left" @click="novo()"/>
                        <Button icon="pi pi-refresh" @Click="reload()"/>
                </div>
        </template>  
        <Column field="id" header="ID" :sortable="true"></Column>
        <Column field="nome" header="Nome" :sortable="true"></Column>
        <Column field="rgb" header="RGB" :sortable="true"></Column>
        <Column field="ativo" header="Ativo" :sortable="true"></Column>
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
            Total de cores cadastradas: {{cores ? cores.length : 0 }}
        </template>   
    </DataTable>
  </div>
</template>

<script>
  import axios from 'axios';
export default {
  data() {
    return {
      cores: []
    }
  },
  methods: {
    load() {
      axios
      .get('http://localhost:8080/cor')
      .then(resp => {
        this.cores = resp.data
      })
    },
    editar(cor) {
            this.$router.push(`/cor-form/${cor.id}`)
    },
    novo() {
            this.$router.push('/cor-form/')
    },
    excluir(cor) {
            const id = cor.id
            axios
                .delete(`http://localhost:8080/cor/${id}`)
                .then(this.load())
                .catch(error => alert(error))
                
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