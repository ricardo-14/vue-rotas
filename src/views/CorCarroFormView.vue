<template>
  <div>
    <h2>Cadastro de Cor</h2>
    <form @submit.prevent="salvar()">
        <label for="nome" id="label" >Nome: </label>
        <InputText type="text" v-model="cor.nome"/><br><br>
        
        <label for="rgb" id="label">RGB: </label>
        <InputText type="text" v-model="cor.rgb"/><br><br>
        
        <Checkbox v-model="cor.ativo" :binary="true" />
        <label for="ativo" id="label"> Ativo</label><br><br>

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