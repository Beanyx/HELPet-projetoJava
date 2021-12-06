<template>
  <div>
    <Navegacao />
    <div class="mx-auto" style="max-width: 1000px; padding: 30px">
      <h1>{{ animal.nome }}</h1>
      <h4>{{ animal.tipo }}, {{ animal.sexo }}, {{ animal.raca }}</h4>
      <div>
        <b-button @click="showModal = true" pill variant="info">
          <b-icon icon="plus"></b-icon>
        </b-button>
      </div>
      <ul>
        <li :key="lar.id" v-for="lar in larTemp">
            Nome: {{ lar.nome }}
        </li>
        <li :key="lar.id" v-for="lar in larTemp">
            CPF: {{ lar.cpf }}
        </li>
        <li :key="lar.id" v-for="lar in larTemp">
            Telefone: {{ lar.telefone }}
        </li>
      </ul>

      <b-modal id="modal-larTemp" size="lg" v-model="showModal" hide-footer>
        <h1>Lar Temporário</h1>
        <b-container fluid>
          <b-row class="my-1">
            <b-col sm="1">
              <label for="nome">Nome:</label>
            </b-col>
            <b-col sm="5">
              <b-form-input
                id="nome"
                size="sm"
                placeholder="Nome"
                v-model="novoLar.nome"
              ></b-form-input>
            </b-col>
            <b-col sm="1">
              <label for="cpf">CPF:</label>
            </b-col>
            <b-col sm="5">
              <b-form-input
                id="cpf"
                size="sm"
                placeholder="cpf"
                v-model="novoLar.cpf"
              >
              </b-form-input>
            </b-col>
            <b-col sm="1">
              <label for="telefone">Telefone:</label>
            </b-col>
            <b-col sm="5">
              <b-form-input
                id="telefone"
                size="sm"
                placeholder="telefone"
                v-model="novoLar.telefone"
              >
              </b-form-input>
            </b-col>
          </b-row>
        </b-container>
        <b-button class="mt-3" block variant="success" @click="criarNovoLar"
          >Atualizar Lar Temporário</b-button
        >
        <b-button class="mt-3" block variant="danger" @click="fecharModal"
          >Fechar</b-button
        >
      </b-modal>
    </div>
  </div>
</template>

<script>
export default {
  asyncData( {params} ){
      if (params.larTemp === "Totó" | params.larTemp === "Arnold"){
        lar =
        {
          id: 1,
          nome: 'Maurício',
          cpf: '123.123.123-50',
          telefone: '12 997895642'
        }
      } else if (params.larTemp === "Lili" | params.larTemp === "Bela"){
        lar =
        {
          id: 2,
          nome: 'Joana',
          cpf: '111.222.333-44',
          telefone: '(11) 98877-6655'
        }
      }

    return {lar};
  },

  data: function(){
    return {
      showModal: false,
      lar: {
        nome: '',
        cpf: '',
        telefone: '',
      },
      novoLar: {
        nome: '',
        cpf: '',
        telefone: '',
      },
    }
  },
  methods: {
    criarNovoLar(event) {
      //Enviar para o servidor o novo lar
      this.larTemp.push({
        id: null,
        nome: this.novoLar.nome,
        cpf: this.novoLar.cpf,
        telefone: this.novoLar.telefone,
      })
      console.log(this.lar)
      this.fecharModal(event)
    },
    fecharModal(event) {
      this.novoLar = {
        nome: '',
        cpf: '',
        telefone: '',
      }
      this.$bvModal.hide('modal-larTemp')
    },
  },
}
</script>
