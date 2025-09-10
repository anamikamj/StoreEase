import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card";
import { Button } from "@/components/ui/button";
import { Badge } from "@/components/ui/badge";
import { Book, Shirt, Beaker, PenTool, ArrowRight, Package } from "lucide-react";
import { Link } from "react-router-dom";
import Header from "@/components/Header";

const Categories = () => {
  const categories = [
    {
      id: "uniforms",
      name: "Uniforms",
      description: "College uniforms, shirts, trousers, and accessories",
      icon: Shirt,
      itemCount: 15,
      color: "bg-blue-100 text-blue-800",
      items: [
        { name: "College Shirt - White", price: 320, stock: 25 },
        { name: "College Trousers - Black", price: 450, stock: 18 },
        { name: "College Blazer", price: 1200, stock: 8 },
        { name: "College Tie", price: 180, stock: 35 }
      ]
    },
    {
      id: "books",
      name: "Books",
      description: "Textbooks, reference books, and study materials",
      icon: Book,
      itemCount: 45,
      color: "bg-green-100 text-green-800",
      items: [
        { name: "Data Structures & Algorithms", price: 680, stock: 12 },
        { name: "Computer Networks", price: 620, stock: 8 },
        { name: "Database Management Systems", price: 580, stock: 15 },
        { name: "Software Engineering", price: 640, stock: 6 }
      ]
    },
    {
      id: "lab-equipment",
      name: "Lab Equipment",
      description: "Lab coats, safety equipment, and practical tools",
      icon: Beaker,
      itemCount: 28,
      color: "bg-purple-100 text-purple-800",
      items: [
        { name: "Engineering Lab Coat", price: 450, stock: 20 },
        { name: "Safety Goggles", price: 180, stock: 30 },
        { name: "Lab Manual - CSE", price: 120, stock: 25 },
        { name: "Digital Multimeter", price: 850, stock: 5 }
      ]
    },
    {
      id: "stationery",
      name: "Stationery",
      description: "Notebooks, pens, calculators, and office supplies",
      icon: PenTool,
      itemCount: 62,
      color: "bg-orange-100 text-orange-800",
      items: [
        { name: "Graph Paper Notebook", price: 45, stock: 150 },
        { name: "Scientific Calculator", price: 1200, stock: 12 },
        { name: "Mechanical Pencil Set", price: 85, stock: 40 },
        { name: "File Folders - Set of 5", price: 120, stock: 60 }
      ]
    }
  ];

  const getStockStatus = (stock: number) => {
    if (stock === 0) return { text: "Out of Stock", color: "bg-red-100 text-red-800" };
    if (stock < 10) return { text: "Low Stock", color: "bg-yellow-100 text-yellow-800" };
    return { text: "In Stock", color: "bg-green-100 text-green-800" };
  };

  return (
    <div className="min-h-screen bg-background">
      <Header />
      
      <main className="container px-4 py-8">
        <div className="mb-8">
          <h1 className="text-3xl font-bold text-foreground mb-2">Shop by Categories</h1>
          <p className="text-muted-foreground">Browse items organized by category for easy shopping</p>
        </div>

        <div className="space-y-8">
          {categories.map((category) => (
            <Card key={category.id} className="shadow-card hover:shadow-feature transition-all duration-300">
              <CardHeader className="pb-4">
                <div className="flex items-center justify-between">
                  <div className="flex items-center space-x-4">
                    <div className="h-12 w-12 rounded-lg bg-hero-gradient flex items-center justify-center">
                      <category.icon className="h-6 w-6 text-white" />
                    </div>
                    <div>
                      <CardTitle className="text-xl">{category.name}</CardTitle>
                      <CardDescription>{category.description}</CardDescription>
                    </div>
                  </div>
                  <div className="text-right">
                    <Badge className={category.color}>
                      {category.itemCount} items
                    </Badge>
                  </div>
                </div>
              </CardHeader>
              <CardContent>
                <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-4 gap-4 mb-6">
                  {category.items.map((item, index) => (
                    <div key={index} className="bg-muted/50 rounded-lg p-4">
                      <div className="flex items-center justify-between mb-2">
                        <h4 className="font-medium text-sm">{item.name}</h4>
                        <Badge className={getStockStatus(item.stock).color} variant="secondary">
                          {getStockStatus(item.stock).text}
                        </Badge>
                      </div>
                      <div className="flex items-center justify-between">
                        <span className="text-lg font-bold text-primary">₹{item.price}</span>
                        <span className="text-xs text-muted-foreground">{item.stock} units</span>
                      </div>
                    </div>
                  ))}
                </div>
                <div className="flex justify-between items-center">
                  <span className="text-sm text-muted-foreground">
                    Showing 4 of {category.itemCount} items
                  </span>
                  <Link to={`/store?category=${category.id}`}>
                    <Button variant="outline" className="border-primary text-primary hover:bg-primary/5">
                      View All {category.name}
                      <ArrowRight className="h-4 w-4 ml-2" />
                    </Button>
                  </Link>
                </div>
              </CardContent>
            </Card>
          ))}
        </div>

        {/* Quick Stats */}
        <div className="mt-12 bg-feature-gradient rounded-lg p-8">
          <div className="text-center mb-8">
            <h2 className="text-2xl font-bold text-foreground mb-2">Store Overview</h2>
            <p className="text-muted-foreground">Your one-stop shop for all academic needs</p>
          </div>
          <div className="grid grid-cols-2 md:grid-cols-4 gap-6">
            <div className="text-center">
              <div className="text-3xl font-bold text-primary mb-1">150+</div>
              <div className="text-sm text-muted-foreground">Total Items</div>
            </div>
            <div className="text-center">
              <div className="text-3xl font-bold text-primary mb-1">4</div>
              <div className="text-sm text-muted-foreground">Categories</div>
            </div>
            <div className="text-center">
              <div className="text-3xl font-bold text-primary mb-1">95%</div>
              <div className="text-sm text-muted-foreground">In Stock</div>
            </div>
            <div className="text-center">
              <div className="text-3xl font-bold text-primary mb-1">24/7</div>
              <div className="text-sm text-muted-foreground">Online Access</div>
            </div>
          </div>
        </div>
      </main>
    </div>
  );
};

export default Categories;