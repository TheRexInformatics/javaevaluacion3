
  Chart.register(ChartDataLabels);

  // Título fijo
  document.getElementById('nombreJugador').textContent = 'Tus estadísticas como jugador';

  const paletaSurviFondo = [
    'rgba(102, 204, 255, 0.7)',
    'rgba(51, 153, 102, 0.7)',
    'rgba(0, 102, 51, 0.7)'
  ];
  const paletaSurviBorde = [
    'rgba(102, 204, 255, 1)',
    'rgba(51, 153, 102, 1)',
    'rgba(0, 102, 51, 1)'
  ];

  const paletaKillerFondo = [
    'rgba(255, 99, 132, 0.7)',
    'rgba(204, 0, 0, 0.7)',
    'rgba(153, 0, 0, 0.7)'
  ];
  const paletaKillerBorde = [
    'rgba(255, 99, 132, 1)',
    'rgba(204, 0, 0, 1)',
    'rgba(153, 0, 0, 1)'
  ];

  const datosSurvi = {
    dia: [5, 7, 8],
    semana: [10, 15, 12],
    mes: [20, 24, 27]
  };
  const datosKiller = {
    dia: [5, 8, 5],
    semana: [10, 30, 12],
    mes: [22, 20, 30]
  };

  const etiquetasSurvi = ['Escape', 'Reparaciones', 'Curaciones'];
  const etiquetasKiller = ['Kills', 'Ataques', 'Victorias'];

  const ctxSurvi = document.getElementById('graficoSurvi').getContext('2d');
  const graficoSurvi = new Chart(ctxSurvi, {
    type: 'bar',
    data: {
      labels: etiquetasSurvi,
      datasets: [{
        label: 'Acciones realizadas',
        data: datosSurvi.semana,
        backgroundColor: paletaSurviFondo,
        borderColor: paletaSurviBorde,
        borderWidth: 1
      }]
    },
    options: {
      responsive: true,
      animation: { duration: 1200, easing: 'easeOutBounce' },
      plugins: {
        legend: { display: false },
        datalabels: { 
          color: '#333', 
          anchor: 'end', 
          align: 'top', 
          font: { weight: 'bold' },
          formatter: value => Math.round(value)
        },
        tooltip: {
          callbacks: { label: ctx => `${ctx.label}: ${Math.round(ctx.raw)} acciones` }
        }
      },
      scales: { y: { beginAtZero: true } }
    },
    plugins: [ChartDataLabels]
  });

  const ctxKiller = document.getElementById('graficoKiller').getContext('2d');
  const graficoKiller = new Chart(ctxKiller, {
    type: 'bar',
    data: {
      labels: etiquetasKiller,
      datasets: [{
        label: 'Acciones realizadas',
        data: datosKiller.semana,
        backgroundColor: paletaKillerFondo,
        borderColor: paletaKillerBorde,
        borderWidth: 1
      }]
    },
    options: {
      responsive: true,
      animation: { duration: 1200, easing: 'easeOutBounce' },
      plugins: {
        legend: { display: false },
        datalabels: { 
          color: '#333', 
          anchor: 'end', 
          align: 'top', 
          font: { weight: 'bold' },
          formatter: value => Math.round(value)
        },
        tooltip: {
          callbacks: { label: ctx => `${ctx.label}: ${Math.round(ctx.raw)} acciones` }
        }
      },
      scales: { y: { beginAtZero: true } }
    },
    plugins: [ChartDataLabels]
  });

  document.getElementById('selectSurvi').addEventListener('change', e => {
    const periodo = e.target.value;
    graficoSurvi.data.datasets[0].data = datosSurvi[periodo];
    graficoSurvi.update();
  });

  document.getElementById('selectKiller').addEventListener('change', e => {
    const periodo = e.target.value;
    graficoKiller.data.datasets[0].data = datosKiller[periodo];
    graficoKiller.update();
  });