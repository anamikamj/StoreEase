import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card";
import { 
  Package, 
  ShoppingCart, 
  Bell, 
  BarChart3, 
  Users, 
  CreditCard,
  Search,
  Filter,
  Clock,
  Shield
} from "lucide-react";

const Features = () => {
  const userFeatures = [
    {
      icon: ShoppingCart,
      title: "Smart Shopping Cart",
      description: "Add items to cart with real-time availability and seamless checkout process"
    },
    {
      icon: Search,
      title: "Advanced Search & Filter",
      description: "Find items quickly with category-based filtering and intelligent search"
    },
    {
      icon: Bell,
      title: "Restock Notifications",
      description: "Get alerted when your favorite out-of-stock items are back in inventory"
    },
    {
      icon: CreditCard,
      title: "Online Payments",
      description: "Secure payment processing with order tracking and purchase history"
    },
    {
      icon: Filter,
      title: "Category Browsing",
      description: "Browse by uniforms, books, lab equipment, and stationery with ease"
    }
  ];

  const managerFeatures = [
    {
      icon: Package,
      title: "Inventory Management",
      description: "Add, update, and track all store items with real-time stock levels"
    },
    {
      icon: BarChart3,
      title: "Analytics Dashboard",
      description: "View sales reports, stock analytics, and performance insights"
    },
    {
      icon: Bell,
      title: "Low Stock Alerts",
      description: "Automated notifications when inventory reaches minimum thresholds"
    },
    {
      icon: Users,
      title: "Order Management",
      description: "Process orders, manage payments, and track customer purchases"
    },
    {
      icon: Clock,
      title: "Store Hours Control",
      description: "Set and display store operating hours with automated status updates"
    }
  ];

  return (
    <section id="features" className="py-20 bg-feature-gradient">
      <div className="container px-4">
        <div className="text-center mb-16">
          <h2 className="text-3xl md:text-4xl font-bold text-foreground mb-4">
            Comprehensive Store Management
          </h2>
          <p className="text-lg text-muted-foreground max-w-2xl mx-auto">
            StoreEase provides tailored features for both students and store managers, 
            ensuring efficient operations and excellent user experience.
          </p>
        </div>

        {/* User Features */}
        <div className="mb-16">
          <h3 className="text-2xl font-bold text-center mb-8 text-primary">For Students & Staff</h3>
          <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
            {userFeatures.map((feature, index) => (
              <Card key={index} className="bg-card-gradient shadow-card hover:shadow-feature transition-all duration-300 hover:-translate-y-1">
                <CardHeader>
                  <div className="h-12 w-12 rounded-lg bg-hero-gradient flex items-center justify-center mb-4">
                    <feature.icon className="h-6 w-6 text-white" />
                  </div>
                  <CardTitle className="text-lg">{feature.title}</CardTitle>
                </CardHeader>
                <CardContent>
                  <CardDescription className="text-sm leading-relaxed">
                    {feature.description}
                  </CardDescription>
                </CardContent>
              </Card>
            ))}
          </div>
        </div>

        {/* Manager Features */}
        <div>
          <h3 className="text-2xl font-bold text-center mb-8 text-primary">For Store Managers</h3>
          <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
            {managerFeatures.map((feature, index) => (
              <Card key={index} className="bg-card-gradient shadow-card hover:shadow-feature transition-all duration-300 hover:-translate-y-1">
                <CardHeader>
                  <div className="h-12 w-12 rounded-lg bg-gradient-to-br from-accent to-accent/80 flex items-center justify-center mb-4">
                    <feature.icon className="h-6 w-6 text-white" />
                  </div>
                  <CardTitle className="text-lg">{feature.title}</CardTitle>
                </CardHeader>
                <CardContent>
                  <CardDescription className="text-sm leading-relaxed">
                    {feature.description}
                  </CardDescription>
                </CardContent>
              </Card>
            ))}
          </div>
        </div>
      </div>
    </section>
  );
};

export default Features;