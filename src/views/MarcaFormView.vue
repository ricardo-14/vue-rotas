<template>
    <div>
        <h1>Cadastro de Marcas</h1>
        <form @submit.prevent="salvar()">
            <label for="nome" id="label">Nome: </label>
            <InputText type="text" v-model="marca.nome"/><br><br>
            <Button type="submit" label="Salvar" icon="pi pi-check" iconPos="right"/><br><br>
            <a href="javascript:void(0)" @click="voltar()">Voltar</a>
        </form>
    </div>

</template>

<script>
import axios from 'axios'
export default {
    data() {
        return {
            marca: {}
        }
    },
    mounted() {
        const id = this.$route.params.id
        if (id) {
            axios.get(`https://carros-app-example.herokuapp.com/marca/${id}`).then(resp => this.marca = resp.data)
            .catch(error => {
                alert(error)
                this.$router.push("/marca")
            })
        }
        else {
            this.marca = {}
        }
    },
    methods: {
        salvar() {
            axios.post('https://carros-app-example.herokuapp.com/marca', this.marca)
            .then(() => this.$toast.add({severity:'success', summary: 'Registro gravado!'}))
            .catch(error => this.$toast.add({severity:'error', summary: `Problema na gravação ${error}`}))
        },
        voltar() {
            this.$router.go(-1)
        }
    }
}
</script>

<style>
    #label {
        font-family: Avenir, Helvetica, Arial, sans-serif;
        font-weight: bold;
    }
</style>
