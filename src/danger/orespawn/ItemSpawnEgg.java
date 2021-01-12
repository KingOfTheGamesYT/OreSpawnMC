/*     */ package danger.orespawn;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.monster.EntitySkeleton;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ItemSpawnEgg
/*     */   extends Item
/*     */ {
/*  25 */   public int my_id = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   public ItemSpawnEgg(int i, int j) {
/*  30 */     this.my_id = j;
/*  31 */     this.maxStackSize = 64;
/*  32 */     setCreativeTab(CreativeTabs.tabMisc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10) {
/*  47 */     if (par3World.isRemote)
/*     */     {
/*     */       
/*  50 */       return true;
/*     */     }
/*     */     
/*  53 */     Entity ent = spawn_something(this.my_id, par3World, par4 + 0.5D, par5 + 1.01D, par6 + 0.5D);
/*     */     
/*  55 */     if (ent != null)
/*     */     {
/*     */       
/*  58 */       if (ent instanceof EntityLiving && par1ItemStack.hasDisplayName())
/*     */       {
/*  60 */         ((EntityLiving)ent).setCustomNameTag(par1ItemStack.getDisplayName());
/*     */       }
/*     */     }
/*     */     
/*  64 */     if (!par2EntityPlayer.capabilities.isCreativeMode)
/*     */     {
/*  66 */       par1ItemStack.stackSize--;
/*     */     }
/*     */     
/*  69 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Entity spawn_something(int id, World world, double d0, double d1, double d2) {
/*  79 */     int entityID = 0;
/*  80 */     int skelly_type = 0;
/*  81 */     String name = null;
/*     */     
/*  83 */     switch (id) {
/*     */       case 192:
/*  85 */         skelly_type = 1;
/*  86 */         entityID = 51; break;
/*     */       case 193:
/*  88 */         entityID = 63; break;
/*     */       case 194:
/*  90 */         entityID = 97; break;
/*     */       case 195:
/*  92 */         entityID = 99; break;
/*     */       case 196:
/*  94 */         entityID = 64; break;
/*     */       case 197:
/*  96 */         name = "Girlfriend"; break;
/*     */       case 198:
/*  98 */         name = "Apple Cow"; break;
/*     */       case 363:
/* 100 */         name = "Crystal Apple Cow"; break;
/*     */       case 199:
/* 102 */         name = "Golden Apple Cow"; break;
/*     */       case 200:
/* 104 */         name = "Enchanted Golden Apple Cow"; break;
/*     */       case 202:
/* 106 */         name = "Alosaurus"; break;
/*     */       case 203:
/* 108 */         name = "Cryolophosaurus"; break;
/*     */       case 204:
/* 110 */         name = "Camarasaurus"; break;
/*     */       case 205:
/* 112 */         name = "Velocity Raptor"; break;
/*     */       case 206:
/* 114 */         name = "Hydrolisc"; break;
/*     */       case 207:
/* 116 */         name = "Basilisk"; break;
/*     */       case 201:
/* 118 */         name = "Mothra"; break;
/*     */       case 221:
/* 120 */         name = "Dragonfly"; break;
/*     */       case 223:
/* 122 */         name = "Emperor Scorpion"; break;
/*     */       case 225:
/* 124 */         name = "Scorpion"; break;
/*     */       case 227:
/* 126 */         name = "CaveFisher"; break;
/*     */       case 229:
/* 128 */         name = "Baby Dragon"; break;
/*     */       case 231:
/* 130 */         name = "Baryonyx"; break;
/*     */       case 233:
/* 132 */         name = "WTF?"; break;
/*     */       case 235:
/* 134 */         name = "Bird"; break;
/*     */       case 237:
/* 136 */         name = "Kyuubi"; break;
/*     */       case 239:
/* 138 */         name = "Alien"; break;
/*     */       case 241:
/* 140 */         name = "Attack Squid"; break;
/*     */       case 243:
/* 142 */         name = "Water Dragon"; break;
/*     */       case 245:
/* 144 */         name = "The Kraken"; break;
/*     */       case 247:
/* 146 */         name = "Lizard"; break;
/*     */       case 249:
/* 148 */         name = "Cephadrome"; break;
/*     */       case 251:
/* 150 */         name = "Dragon"; break;
/*     */       case 254:
/* 152 */         name = "Bee"; break;
/*     */       case 262:
/* 154 */         name = "Jumpy Bug"; break;
/*     */       case 263:
/* 156 */         name = "Spit Bug"; break;
/*     */       case 264:
/* 158 */         name = "Stink Bug"; break;
/*     */       case 265:
/* 160 */         name = "Ostrich"; break;
/*     */       case 266:
/* 162 */         name = "Gazelle"; break;
/*     */       case 267:
/* 164 */         name = "Chipmunk"; break;
/*     */       case 274:
/* 166 */         name = "Creeping Horror"; break;
/*     */       case 275:
/* 168 */         name = "Terrible Terror"; break;
/*     */       case 276:
/* 170 */         name = "Cliff Racer"; break;
/*     */       case 277:
/* 172 */         name = "Triffid"; break;
/*     */       case 278:
/* 174 */         name = "Nightmare"; break;
/*     */       case 279:
/* 176 */         name = "Lurking Terror"; break;
/*     */       case 288:
/* 178 */         name = "Small Worm"; break;
/*     */       case 289:
/* 180 */         name = "Medium Worm"; break;
/*     */       case 290:
/* 182 */         name = "Large Worm"; break;
/*     */       case 291:
/* 184 */         name = "Cassowary"; break;
/*     */       case 292:
/* 186 */         name = "Cloud Shark"; break;
/*     */       case 293:
/* 188 */         name = "Gold Fish"; break;
/*     */       case 294:
/* 190 */         name = "Leaf Monster"; break;
/*     */       case 295:
/* 192 */         name = "T-Shirt"; break;
/*     */       case 280:
/* 194 */         name = "Mobzilla"; break;
/*     */       case 298:
/* 196 */         name = "Ender Knight"; break;
/*     */       case 299:
/* 198 */         name = "Ender Reaper"; break;
/*     */       case 301:
/* 200 */         name = "Beaver"; break;
/*     */       case 306:
/* 202 */         name = "Dungeon Beast"; break;
/*     */       case 303:
/* 204 */         name = "Vortex"; break;
/*     */       case 302:
/* 206 */         name = "Rotator"; break;
/*     */       case 304:
/* 208 */         name = "Peacock"; break;
/*     */       case 305:
/* 210 */         name = "Fairy"; break;
/*     */       case 307:
/* 212 */         name = "Rat"; break;
/*     */       case 308:
/* 214 */         name = "Flounder"; break;
/*     */       case 309:
/* 216 */         name = "Whale"; break;
/*     */       case 310:
/* 218 */         name = "Irukandji"; break;
/*     */       case 311:
/* 220 */         name = "Skate"; break;
/*     */       case 312:
/* 222 */         name = "Crystal Urchin"; break;
/*     */       case 324:
/* 224 */         name = "Bomb-Omb"; break;
/*     */       case 325:
/* 226 */         name = "Robo-Pounder"; break;
/*     */       case 326:
/* 228 */         name = "Robo-Gunner"; break;
/*     */       case 327:
/* 230 */         name = "Robo-Warrior"; break;
/*     */       case 328:
/* 232 */         name = "Ghost"; break;
/*     */       case 329:
/* 234 */         name = "Ghost Pumpkin Skelly"; break;
/*     */       case 330:
/* 236 */         name = "Ant"; break;
/*     */       case 331:
/* 238 */         name = "Red Ant"; break;
/*     */       case 332:
/* 240 */         name = "Rainbow Ant"; break;
/*     */       case 333:
/* 242 */         name = "Unstable Ant"; break;
/*     */       case 334:
/* 244 */         name = "Termite"; break;
/*     */       case 335:
/* 246 */         name = "Butterfly"; break;
/*     */       case 336:
/* 248 */         name = "Moth"; break;
/*     */       case 337:
/* 250 */         name = "Mosquito"; break;
/*     */       case 338:
/* 252 */         name = "Firefly"; break;
/*     */       case 339:
/* 254 */         name = "T. Rex"; break;
/*     */       case 340:
/* 256 */         name = "Hercules Beetle"; break;
/*     */       case 341:
/* 258 */         name = "Mantis"; break;
/*     */       case 342:
/* 260 */         name = "Stinky"; break;
/*     */       case 343:
/* 262 */         name = "Robo-Sniper"; break;
/*     */       case 344:
/* 264 */         name = "Coin"; break;
/*     */       case 349:
/* 266 */         name = "Boyfriend"; break;
/*     */       case 350:
/* 268 */         name = "The King"; break;
/*     */       case 366:
/* 270 */         name = "The Queen"; break;
/*     */       case 351:
/* 272 */         name = "The Prince"; break;
/*     */       case 352:
/* 274 */         name = "Easter Bunny"; break;
/*     */       case 353:
/* 276 */         name = "Molenoid"; break;
/*     */       case 354:
/* 278 */         name = "Sea Monster"; break;
/*     */       case 355:
/* 280 */         name = "Sea Viper"; break;
/*     */       case 356:
/* 282 */         name = "CaterKiller"; break;
/*     */       case 358:
/* 284 */         name = "Leonopteryx"; break;
/*     */       case 360:
/* 286 */         name = "Hammerhead"; break;
/*     */       case 362:
/* 288 */         name = "Rubber Ducky"; break;
/*     */       case 365:
/* 290 */         name = "Criminal"; break;
/*     */       case 367:
/* 292 */         name = "Brutalfly"; break;
/*     */       case 368:
/* 294 */         name = "Nastysaurus"; break;
/*     */       case 369:
/* 296 */         name = "Pointysaurus"; break;
/*     */       case 370:
/* 298 */         name = "Cricket"; break;
/*     */       case 371:
/* 300 */         name = "The Princess"; break;
/*     */       case 372:
/* 302 */         name = "Frog"; break;
/*     */       case 378:
/* 304 */         name = "Jeffery"; break;
/*     */       case 379:
/* 306 */         name = "Robot Red Ant"; break;
/*     */       case 380:
/* 308 */         name = "Robot Spider"; break;
/*     */       case 381:
/* 310 */         name = "Spider Driver"; break;
/*     */       case 383:
/* 312 */         name = "Crab";
/*     */         break;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 318 */     Entity ent = null;
/*     */     
/* 320 */     if (entityID != 0 || name != null) {
/*     */ 
/*     */ 
/*     */       
/* 324 */       ent = spawnCreature(world, entityID, name, d0, d1, d2);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 329 */       if (ent != null)
/*     */       {
/* 331 */         if (entityID == 51 && skelly_type != 0) {
/*     */           
/* 333 */           EntitySkeleton sk = (EntitySkeleton)ent;
/* 334 */           sk.setSkeletonType(skelly_type);
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 340 */     return ent;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Entity spawnCreature(World par0World, int par1, String name, double par2, double par4, double par6) {
/* 352 */     Entity var8 = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 358 */     if (name == null) {
/* 359 */       var8 = EntityList.createEntityByID(par1, par0World);
/*     */     } else {
/* 361 */       var8 = EntityList.createEntityByName(name, par0World);
/*     */     } 
/*     */     
/* 364 */     if (var8 != null) {
/*     */ 
/*     */       
/* 367 */       var8.setLocationAndAngles(par2, par4, par6, par0World.rand.nextFloat() * 360.0F, 0.0F);
/* 368 */       par0World.spawnEntityInWorld(var8);
/*     */       
/* 370 */       ((EntityLiving)var8).playLivingSound();
/*     */     } 
/*     */     
/* 373 */     return var8;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void registerIcons(IIconRegister iconRegister) {
/* 381 */     this.itemIcon = iconRegister.registerIcon("OreSpawn:" + getUnlocalizedName().substring(5));
/*     */   }
/*     */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\ItemSpawnEgg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */