using System.Windows;

namespace MariscosRecioAPK
{
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            ConfigurarVentana();
        }

        private void ConfigurarVentana()
        {
            // Obtenemos las dimensiones reales de la pantalla del usuario
            double anchoPantalla = SystemParameters.PrimaryScreenWidth;
            double altoPantalla = SystemParameters.PrimaryScreenHeight;

            // Calculamos el 80%
            this.Width = anchoPantalla * 0.8;
            this.Height = altoPantalla * 0.8;

            // Forzamos el centrado después de cambiar el tamaño
            this.WindowStartupLocation = WindowStartupLocation.CenterScreen;
        }

        // --- Eventos de los botones ---

        private void BtnClientes_Click(object sender, RoutedEventArgs e)
        {
            txtTituloSeccion.Text = "Gestión de Clientes";
            // Futuro código de clientes
        }

        private void BtnAlmacen_Click(object sender, RoutedEventArgs e)
        {
            txtTituloSeccion.Text = "Control de Almacén";
            // Futuro código de almacén
        }

        private void BtnPedidos_Click(object sender, RoutedEventArgs e)
        {
            txtTituloSeccion.Text = "Pedidos en Curso";
            // Futuro código de pedidos
        }

        private void BtnSalir_Click(object sender, RoutedEventArgs e)
        {
            if (MessageBox.Show("¿Cerrar Mariscos Recio?", "Salir", MessageBoxButton.YesNo, MessageBoxImage.Question) == MessageBoxResult.Yes)
            {
                Application.Current.Shutdown();
            }
        }
    }
}