using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using practicum_5.CustomerServiceReference;

namespace practicum_5
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class Login : Window
    {
        public Login()
        {
            InitializeComponent();
        }

        private void Login_Button_Click(object sender, RoutedEventArgs e)
        {

            CustomerServiceClient CustomerServiceClient = new CustomerServiceClient();
            Customer newCustomer = CustomerServiceClient.LoginCustomer(username.Text, password.Text);
            Console.WriteLine(newCustomer);
            if (!newCustomer.Equals(null))
            {
                Buy BuyWindow = new Buy();
                BuyWindow.Show();

                this.Close();
            }
            else
            {
                MessageBox.Show("Foute login");
            }
        }

        private void To_Regsister(object sender, RoutedEventArgs e)
        {
            Register RegisterWindow = new Register();
            RegisterWindow.Show();

            this.Close();
        }
    }
}
