const app = Vue.createApp({
  data() {
    return {
      alumnosUrl: "/api/student",
      alumnos: [],
      nombreAlumno: "",
      apellidoAlumno: "",
      emailAlumno: "",
      cursosAlumno: "",
      alumnoBorrar: "",
      alumnoModificar: "",
      profesoresUrl: "/api/professor",
      profesores: [],
      nombreProfesor: "",
      apellidoProfesor: "",
      cursosProfesor: "",
      profesorBorrar: "",
      cursosUrl: "/api/courses",
      cursos: [],
      cursosFiltrados: [],
      cursosFiltrados2:[],
      nombreCurso: "",
      horario: "",
      cursosProfesor: "",
      cursoBorrar: "",
      backupAlumnos: [],
      textoBuscar: "",
      textoBuscar2: "",
      backupProfesores:[]
    };
  },

  created() {
    this.obtenerAlumnos(this.alumnosUrl);
    this.obtenerProfesores(this.profesoresUrl);
    this.obtenerCursos(this.cursosUrl);
  },

  methods: {
    obtenerAlumnos(URL) {
      this.alumnos.forEach((alumnos) =>
        !this.cursos.includes(alumnos.courses)
          ? this.cursos.push(alumnos.courses)
          : ""
      );

      axios.get(URL).then((response) => {
        this.alumnos = response.data;
        this.backupAlumnos = response.data;

        console.log(this.alumnos);
      });
    },
    mostrarDatos(alumno) {
      this.nombreAlumno = alumno.nombreAlumno;
      this.apellidoAlumno = alumno.alumnoApellido;
      this.emailAlumno = alumno.emailAlumno;
      this.cursosAlumno = alumno.cursosAlumno;
    },

    borrarAlumno(alumno) {
      axios.patch("/api/deleteStudent", "id=" + alumno.id).then(() => {
        Swal.fire({
          background: "#212121",
          confirmButtonColor: "#1bb5db",
          title: "El alumno ha sido eliminado",
        }).then((x) => window.location.reload());
      });
    },

    obtenerProfesores(URL) {
      axios.get(URL).then((response) => {
        this.profesores = response.data;
        console.log(this.profesores);
      });
    },
    mostrarDatos(profesor) {
      this.nombreProfesor = profesor.nombreProfesor;
      this.apellidoProfesor = profesor.apellidoProfesor;
      this.cursosProfesor = profesor.cursosProfesor;
    },
    borrarProfesor(profesor) {
      axios.patch("/api/deleteProfessor", "id=" + profesor.id).then(() => {
        Swal.fire({
          background: "#212121",
          confirmButtonColor: "#1bb5db",
          title: "El profesor ha sido eliminado",
        }).then((x) => window.location.reload());
      });
    },
    obtenerCursos(URL) {
      axios.get(URL).then((response) => {
        this.cursos = response.data;

        console.log(this.cursos);
      });
    },
    mostrarDatos(curso) {
      this.nombreCurso = curso.nombreCurso;
      this.horario = curso.horario;
      this.cursosProfesor = curso.cursosProfesor;
    },
    borrarCurso(curso) {
      axios.patch("/api/deleteCourse", "id=" + curso.id).then(() => {
        Swal.fire({
          background: "#212121",
          confirmButtonColor: "#1bb5db",
          title: "El curso ha sido eliminado",
        }).then((x) => window.location.reload());
      });
    },
    agregarCurso() {
      Swal.fire({
        background: "#212121",
        color: "white",
        title: "??Desea agregar un nuevo curso?",
        // icon: 'warning',
        showDenyButton: true,
        showCancelButton: false,
        confirmButtonColor: "#1bb5db",
        denyButtonColor: "#1bb5db",
        // cancelButtonColor: '#d33',
        // cancelButtonText: 'Programacion',
        confirmButtonText: "Marketing",
        denyButtonText: "Community Manager",
      })
        .then((result) => {
          if (result.isConfirmed) {
            axios.post("/api/createCourse", "courseName=MARKETING");
          } else if (result.isDenied) {
            axios.post("/api/createCourse", "courseName=COMMUNITY_MANAGER");
          }
        })
        .then(() => {
          this.numero = this.numeroRandom;
          this.creationDate = this.fechaCuentaNueva;
          window.location.reload();
        })
        .catch((error) => {
          this.error = error.response.data;
        });
    },
    cerrarSesion() {
      const swalWithBootstrapButtons = Swal.mixin({
        customClass: {
          confirmButton: "btn btn-success",
          cancelButton: "btn btn-danger",
        },
        buttonsStyling: false,
      });

      swalWithBootstrapButtons
        .fire({
          background: "#212121",
          color: "white",
          title: "??Seguro deseas cerrar sesi??n?",
          // icon: 'warning',
          showCancelButton: true,
          // confirmButtonColor: '#d14334',
          // cancelButtonColor: '#d33',
          confirmButtonText: "Si",
          cancelButtonText: "No",

          reverseButtons: false,
        })
        .then((result) => {
          if (result.isConfirmed) {
            Swal.fire({
              background: "#212121",
              color: "white",
              position: "top-center",
              // icon: 'success',
              title: "Su sesi??n ha sido finalizada",
              showConfirmButton: false,
              timer: 10500,
            });
            axios
              .post("/api/logout")
              .then((response) => (window.location.href = "/index.html"));
          }
        });
    },
  },
  computed: {
    filtroDoble() {
      let primerFiltro = this.backupAlumnos.filter((alumno) =>
        alumno.name.toLowerCase().includes(this.textoBuscar.toLowerCase())
      );
      console.log(this.cursosFiltrados);
      if (this.cursosFiltrados.length) {
        let alumnosDobleFiltro = [];
        this.cursosFiltrados.forEach((curso) => {
          primerFiltro.forEach((alumno) => {
            if (
              alumno.courses.includes(curso) &&
              !alumnosDobleFiltro.includes(alumno)
            ) {
              alumnosDobleFiltro.push(alumno);
            }
          });
        });
        this.alumnos = alumnosDobleFiltro;
      } else {
        this.alumnos = primerFiltro;
      }
    },
    filtroDoble2() {
      let primerFiltro2 = this.backupProfesores.filter((profesor) =>
        profesor.professorName.toLowerCase().includes(this.textoBuscar2.toLowerCase())
      );
      console.log(this.cursosFiltrados2);
      if (this.cursosFiltrados2.length) {
        let profesoresDobleFiltro = [];
        this.cursosFiltrados2.forEach((curso) => {
          primerFiltro2.forEach((profesor) => {
            if (
              profesor.courses.includes(curso) &&
              !profesoresDobleFiltro.includes(profesor)
            ) {
              profesoresDobleFiltro.push(profesor);
            }
          });
        });
        this.profesores = profesoresDobleFiltro;
      } else {
        this.profesores = primerFiltro2;
      }
    },
    
  },
}).mount("#app");
