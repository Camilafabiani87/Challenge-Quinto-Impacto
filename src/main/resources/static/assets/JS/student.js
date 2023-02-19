const app = Vue.
  createApp({
    data() {
      return {
        cursos: [],
        nombre: "",
        edad: 0,
        fechaNacimiento: "",
        alumnos: [],
        borrarAlumno:""
       
      }
    },

    created() {
      axios.get('/api/student')
        .then(response => {
          this.alumnos = response.data;
          console.log(this.alumnos)
        })
        .catch(function (error) { console.log(error) })
      
},
    methods: {
      inscribir() {
        Swal.fire({
          title: '¿Seguro quieres inscribirte en este Curso?',
          icon: 'warning',
          showCancelButton: true,
          confirmButtonColor: '#3085d6',
          cancelButtonColor: '#d33',
          confirmButtonText: 'Si, inscribirme!'
        })
          .then((result) => {

            if (result.isConfirmed) {
           
              axios.post('/api/registerStudent',
                "name=" + this.nombre + "&age=" + this.edad + "&dateOfBirth=" + this.fechaNacimiento)
                .then(
                  Swal.fire(
                    'Inscripto!',
                    'Has sido inscripto con éxito!',
                    'success')
                    .then(response => window.location.reload())
                )
            }
          })
      },

    },
    borrarAlumno() {
      axios.delete('/api/student', `name=${this.borrarAlumno}`)
        .then(x => window.location.reload())
        .catch(response => Swal.fire({
          icon: 'error',
          title: 'Oops..!',
          text: 'Algún dato es incorrecto!',
        }))
    }
  }
  )

  .mount('#app');