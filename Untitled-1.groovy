<div id="memed-container" style="width: 820px; height: 700px;"></div>

<script

    type="text/javascript"

    src="https://integrations.memed.com.br/modulos/plataforma.sinapse-prescricao/build/sinapse-prescricao.min.js"

    data-token="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.Wzc3OTEyLCJmMGI4Yjg4ZjJhYzc2MDE3ZWFjYzViNWRlMzEzOGFiZCIsIjIwMjQtMTAtMTAiLCJzaW5hcHNlLnByZXNjcmljYW8iLCJwYXJ0bmVyLjMuNzMxMTYiXQ.OAPVBRCF5xKE6exSSFlw8qgysjgNBNZgJNvl7UqG9vg"

    data-container="memed-container">

</script>

<script>

  document.addEventListener('DOMContentLoaded', function () {

    // Esperar o carregamento do módulo de prescrição da Memed

    MdSinapsePrescricao.event.add('core:moduleInit', (module) => {

      if (module.name === 'plataforma.prescricao') {

        // 1. Definir os dados do paciente

        MdHub.command.send('plataforma.prescricao', 'setPaciente', {

          external_id: 'paciente123',  // Identificador do paciente no seu sistema

          nome: 'José da Silva',

          cpf: '99999999999',

          telefone: '99999999999',

        });

        // 2. Bloquear ações de edição/remover paciente

        MdHub.command.send('plataforma.prescricao', 'setFeatureToggle', {

          deletePatient: false,  // Desativa a opção de excluir um paciente

          removePatient: false,  // Desabilita a opção de remover/trocar o paciente

          editPatient: false     // Esconde o formulário de edição do paciente

        });

        // 3. Exibe o módulo de prescrição

        MdHub.module.show('plataforma.prescricao');

      }

    });

  });

</script>