const app = Vue.createApp({
    data() {
        return {
            alumnosUrl:"/api/student",
            alumnos:[],
            alumnosFiltrados:[],
            nombreAlumno:'',
            apellidoAlumno:'',
            emailAlumno:'',
            cursosAlumno:'',
            alumnoBorrar: "",
            profesoresUrl:"/api/professor",
            profesores:[],
            profesoresFiltrados:[],
            nombreProfesor:'',
            apellidoProfesor:'',
            cursosProfesor:'',
            profesorBorrar: "",
            // profesoresUrl:"/api/course",
            cursos:[],
            cursosFiltrados:[],
            nombreCurso:'',
            Horario:'',
            cursosProfesor:'',
            cursoBorrar: "",
            

           
        }
    },

  

    created() {
        this.obtenerAlumnos(this.alumnosUrl)
        this.obtenerProfesores(this.profesoresUrl)
        // this.obtenerCursos(this.profesoresUrl)

    },
   
    methods: {
      
        obtenerAlumnos(URL){
            axios.get(URL)
            .then(response => {
                this.alumnos = response.data
                this.alumnosFiltrados = this.alumnos
                console.log(this.alumnos);
                // this.cursos = response.data.courses
                // console.log(courses);
               
              })
            
        },
        mostrarDatos(alumno){
            this.nombreAlumno = alumno.nombreAlumno
            this.apellidoAlumno = alumno.alumnoApellido
            this.emailAlumno = alumno.emailAlumno
            this.cursosAlumno = alumno.cursosAlumno

        },

        borrarAlumno(alumno) {
        axios.patch('/api/deleteStudent', 'id=' + alumno.id)
            .then(() => {
              Swal.fire({
                background: "#212121",
                confirmButtonColor: "#1bb5db",
                 title: 'El alumno ha sido eliminado'})
                 .then(x => window.location.reload())
            })

        },
            
     

          obtenerProfesores(URL){
            axios.get(URL)
            .then(response => {
                this.profesores = response.data
                this.profesoresFiltrados = this.profesores
                console.log(this.profesores);
           
               
              })
            
        },
        mostrarDatos(profesor){
            this.nombreProfesor= profesor.nombreProfesor
            this.apellidoProfesor = profesor.apellidoProfesor
            this.cursosProfesor = profesor.cursosProfesor

        }, 
        // obtenerCursos(URL){
        //     axios.get(URL)
        //     .then(response => {
        //         this.profesores = response.data
        //         this.profesoresFiltrados = this.profesores
        //         console.log(this.profesores);
           
               
        //       })
            
        // },
        // mostrarDatos(curso){
        //     this.nombreProfesor= profesor.nombreProfesor
        //     this.apellidoProfesor = profesor.apellidoProfesor
        //     this.cursosProfesor = profesor.cursosProfesor

        // }, 
   
},
    computed: {
        
       
    },

}).mount('#app')



