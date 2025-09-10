import { useState } from "react";
import { Card, CardContent, CardDescription, CardHeader, CardTitle } from "@/components/ui/card";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Badge } from "@/components/ui/badge";
import { Select, SelectContent, SelectItem, SelectTrigger, SelectValue } from "@/components/ui/select";
import { Search, ShoppingCart, Filter, Star, Package } from "lucide-react";
import { Link } from "react-router-dom";
import Header from "@/components/Header";

const Store = () => {
  const [searchTerm, setSearchTerm] = useState("");
  const [selectedCategory, setSelectedCategory] = useState("all");
  const [sortBy, setSortBy] = useState("name");

  const items = [
    {
      id: 1,
      name: "Engineering Lab Coat",
      category: "Lab Equipment",
      price: 450,
      stock: 25,
      status: "In Stock",
      rating: 4.5,
      image: "/placeholder.svg"
    },
    {
      id: 2,
      name: "College Uniform - Shirt",
      category: "Uniforms",
      price: 320,
      stock: 5,
      status: "Low Stock",
      rating: 4.2,
      image: "/placeholder.svg"
    },
    {
      id: 3,
      name: "Data Structures & Algorithms",
      category: "Books",
      price: 680,
      stock: 0,
      status: "Out of Stock",
      rating: 4.8,
      image: "/placeholder.svg"
    },
    {
      id: 4,
      name: "Graph Paper Notebook",
      category: "Stationery",
      price: 45,
      stock: 150,
      status: "In Stock",
      rating: 4.0,
      image: "/placeholder.svg"
    },
    {
      id: 5,
      name: "Safety Goggles",
      category: "Lab Equipment",
      price: 180,
      stock: 12,
      status: "Low Stock",
      rating: 4.3,
      image: "/placeholder.svg"
    },
    {
      id: 6,
      name: "College ID Card Holder",
      category: "Stationery",
      price: 25,
      stock: 80,
      status: "In Stock",
      rating: 3.9,
      image: "/placeholder.svg"
    }
  ];

  const categories = ["all", "Uniforms", "Books", "Lab Equipment", "Stationery"];

  const filteredItems = items.filter(item => {
    const matchesSearch = item.name.toLowerCase().includes(searchTerm.toLowerCase());
    const matchesCategory = selectedCategory === "all" || item.category === selectedCategory;
    return matchesSearch && matchesCategory;
  });

  const getStatusColor = (status: string) => {
    switch (status) {
      case "In Stock": return "bg-green-100 text-green-800";
      case "Low Stock": return "bg-yellow-100 text-yellow-800";
      case "Out of Stock": return "bg-red-100 text-red-800";
      default: return "bg-gray-100 text-gray-800";
    }
  };

  return (
    <div className="min-h-screen bg-background">
      <Header />
      
      <main className="container px-4 py-8">
        <div className="mb-8">
          <h1 className="text-3xl font-bold text-foreground mb-2">Campus Store</h1>
          <p className="text-muted-foreground">Browse and purchase items for your academic needs</p>
        </div>

        {/* Search and Filters */}
        <div className="bg-card rounded-lg p-6 shadow-card mb-8">
          <div className="grid grid-cols-1 md:grid-cols-4 gap-4">
            <div className="relative md:col-span-2">
              <Search className="absolute left-3 top-1/2 transform -translate-y-1/2 h-4 w-4 text-muted-foreground" />
              <Input
                placeholder="Search items..."
                value={searchTerm}
                onChange={(e) => setSearchTerm(e.target.value)}
                className="pl-10"
              />
            </div>
            <Select value={selectedCategory} onValueChange={setSelectedCategory}>
              <SelectTrigger>
                <SelectValue placeholder="Category" />
              </SelectTrigger>
              <SelectContent>
                {categories.map((category) => (
                  <SelectItem key={category} value={category}>
                    {category === "all" ? "All Categories" : category}
                  </SelectItem>
                ))}
              </SelectContent>
            </Select>
            <Select value={sortBy} onValueChange={setSortBy}>
              <SelectTrigger>
                <SelectValue placeholder="Sort by" />
              </SelectTrigger>
              <SelectContent>
                <SelectItem value="name">Name</SelectItem>
                <SelectItem value="price-low">Price: Low to High</SelectItem>
                <SelectItem value="price-high">Price: High to Low</SelectItem>
                <SelectItem value="rating">Rating</SelectItem>
              </SelectContent>
            </Select>
          </div>
        </div>

        {/* Items Grid */}
        <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
          {filteredItems.map((item) => (
            <Card key={item.id} className="shadow-card hover:shadow-feature transition-all duration-300 hover:-translate-y-1">
              <CardHeader className="pb-4">
                <div className="aspect-square bg-muted rounded-lg mb-4 flex items-center justify-center">
                  <Package className="h-12 w-12 text-muted-foreground" />
                </div>
                <div className="flex justify-between items-start">
                  <div className="flex-1">
                    <CardTitle className="text-lg mb-1">{item.name}</CardTitle>
                    <CardDescription className="text-sm">{item.category}</CardDescription>
                  </div>
                  <Badge className={getStatusColor(item.status)}>
                    {item.status}
                  </Badge>
                </div>
              </CardHeader>
              <CardContent>
                <div className="space-y-4">
                  <div className="flex items-center justify-between">
                    <div className="text-2xl font-bold text-primary">₹{item.price}</div>
                    <div className="flex items-center space-x-1">
                      <Star className="h-4 w-4 fill-yellow-400 text-yellow-400" />
                      <span className="text-sm text-muted-foreground">{item.rating}</span>
                    </div>
                  </div>
                  <div className="text-sm text-muted-foreground">
                    Stock: <span className="font-medium">{item.stock} units</span>
                  </div>
                  <Button 
                    className="w-full bg-hero-gradient hover:opacity-90"
                    disabled={item.stock === 0}
                  >
                    <ShoppingCart className="h-4 w-4 mr-2" />
                    {item.stock === 0 ? "Out of Stock" : "Add to Cart"}
                  </Button>
                </div>
              </CardContent>
            </Card>
          ))}
        </div>

        {filteredItems.length === 0 && (
          <div className="text-center py-12">
            <Package className="h-16 w-16 text-muted-foreground mx-auto mb-4" />
            <h3 className="text-xl font-semibold text-foreground mb-2">No items found</h3>
            <p className="text-muted-foreground">Try adjusting your search or filter criteria</p>
          </div>
        )}

        {/* Quick Actions */}
        <div className="fixed bottom-6 right-6">
          <Link to="/cart">
            <Button size="lg" className="rounded-full shadow-elegant bg-hero-gradient hover:opacity-90">
              <ShoppingCart className="h-5 w-5 mr-2" />
              Cart (3)
            </Button>
          </Link>
        </div>
      </main>
    </div>
  );
};

export default Store;