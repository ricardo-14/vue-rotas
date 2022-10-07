<template>
  <div>
    <h2>Cadastro de Cores</h2>
    <form @submit.prevent="salvar()">
        <span v-if="mensagem">{{mensagem}}<br/></span>
        <label for="nome">Nome</label>
        <input type="text" size="40" required v-model="cor.nome"/>
        <br>
        <label for="rgb">RGB</label>
        <input type="text" size="10" required v-model="cor.rgb"/>
        <br>
        <label for="ativo">Ativo</label>
        <input type="checkbox" v-model="cor.ativo"/>
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
            cor: {
                nome:'',
                rgb:'',
                ativo:''
            },
            mensagem: null
        }
    },
    mounted() {
        const id = this.$route.params.id
        if (id) {
            axios.get(`https://carros-app-example.herokuapp.com/cor/${id}`)
            .then(resp => this.cor = resp.data)
            .catch(error => {
                alert(error)
                this.$router.push("/cor")
            })
        }
        else {
            this.cor = {
                id:null,
                nome:'',
                rgb:'',
                ativo:false
            }
        }
    },
    methods: {
        salvar() {
            axios.post('https://carros-app-example.herokuapp.com/cor', this.cor)
            .then(() => this.mensagem = "Registro gravado")
            .catch(error => this.mensagem = `Problema na gravação ${error}`)
        },
        voltar() {
            this.$router.go(-1)
        }
    }
}
</script>

<style>

</style>