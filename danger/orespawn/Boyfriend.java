/*      */ package danger.orespawn;
/*      */ 
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.enchantment.Enchantment;
/*      */ import net.minecraft.enchantment.EnchantmentHelper;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.EntityAgeable;
/*      */ import net.minecraft.entity.EntityCreature;
/*      */ import net.minecraft.entity.EntityLiving;
/*      */ import net.minecraft.entity.EntityLivingBase;
/*      */ import net.minecraft.entity.IRangedAttackMob;
/*      */ import net.minecraft.entity.SharedMonsterAttributes;
/*      */ import net.minecraft.entity.ai.EntityAIArrowAttack;
/*      */ import net.minecraft.entity.ai.EntityAIBase;
/*      */ import net.minecraft.entity.ai.EntityAILookIdle;
/*      */ import net.minecraft.entity.ai.EntityAIMoveIndoors;
/*      */ import net.minecraft.entity.ai.EntityAIOpenDoor;
/*      */ import net.minecraft.entity.ai.EntityAIPanic;
/*      */ import net.minecraft.entity.ai.EntityAISwimming;
/*      */ import net.minecraft.entity.ai.EntityAITempt;
/*      */ import net.minecraft.entity.ai.EntityAIWatchClosest;
/*      */ import net.minecraft.entity.monster.EntityCreeper;
/*      */ import net.minecraft.entity.monster.IMob;
/*      */ import net.minecraft.entity.passive.EntityTameable;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.entity.projectile.EntityArrow;
/*      */ import net.minecraft.init.Blocks;
/*      */ import net.minecraft.init.Items;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemArmor;
/*      */ import net.minecraft.item.ItemFood;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.nbt.NBTTagCompound;
/*      */ import net.minecraft.potion.Potion;
/*      */ import net.minecraft.tileentity.TileEntityMobSpawner;
/*      */ import net.minecraft.util.ChatComponentText;
/*      */ import net.minecraft.util.DamageSource;
/*      */ import net.minecraft.util.IChatComponent;
/*      */ import net.minecraft.util.MathHelper;
/*      */ import net.minecraft.util.ResourceLocation;
/*      */ import net.minecraft.world.World;
/*      */ 
/*      */ 
/*      */ 
/*      */ public class Boyfriend
/*      */   extends EntityTameable
/*      */   implements IRangedAttackMob
/*      */ {
/*   49 */   public int which_guy = 0;
/*   50 */   public int which_wet_guy = 0;
/*   51 */   public int wet_count = 0;
/*   52 */   private int auto_heal = 200;
/*   53 */   private int force_sync = 50;
/*   54 */   private int fight_sound_ticker = 0;
/*   55 */   private int taunt_sound_ticker = 0;
/*   56 */   private int had_target = 0;
/*   57 */   private int voice = 0;
/*   58 */   private float moveSpeed = 0.3F;
/*   59 */   private int voice_enable = 1;
/*   60 */   public int passenger = 0;
/*   61 */   private int is_prince = 0;
/*   62 */   private static final ResourceLocation DryTexture0 = new ResourceLocation("orespawn", "boyfriend0.png");
/*   63 */   private static final ResourceLocation DryTexture1 = new ResourceLocation("orespawn", "boyfriend1.png");
/*   64 */   private static final ResourceLocation DryTexture2 = new ResourceLocation("orespawn", "boyfriend2.png");
/*   65 */   private static final ResourceLocation DryTexture3 = new ResourceLocation("orespawn", "boyfriend3.png");
/*   66 */   private static final ResourceLocation DryTexture4 = new ResourceLocation("orespawn", "boyfriend4.png");
/*   67 */   private static final ResourceLocation DryTexture5 = new ResourceLocation("orespawn", "boyfriend5.png");
/*   68 */   private static final ResourceLocation DryTexture6 = new ResourceLocation("orespawn", "boyfriend6.png");
/*   69 */   private static final ResourceLocation DryTexture7 = new ResourceLocation("orespawn", "boyfriend7.png");
/*   70 */   private static final ResourceLocation DryTexture8 = new ResourceLocation("orespawn", "boyfriend8.png");
/*   71 */   private static final ResourceLocation DryTexture9 = new ResourceLocation("orespawn", "boyfriend9.png");
/*   72 */   private static final ResourceLocation DryTexture10 = new ResourceLocation("orespawn", "boyfriend10.png");
/*   73 */   private static final ResourceLocation DryTexture11 = new ResourceLocation("orespawn", "boyfriend11.png");
/*   74 */   private static final ResourceLocation DryTexture12 = new ResourceLocation("orespawn", "boyfriend12.png");
/*   75 */   private static final ResourceLocation DryTexture13 = new ResourceLocation("orespawn", "boyfriend13.png");
/*   76 */   private static final ResourceLocation DryTexture14 = new ResourceLocation("orespawn", "boyfriend14.png");
/*   77 */   private static final ResourceLocation DryTexture15 = new ResourceLocation("orespawn", "boyfriend15.png");
/*   78 */   private static final ResourceLocation DryTexture16 = new ResourceLocation("orespawn", "boyfriend16.png");
/*   79 */   private static final ResourceLocation DryTexture17 = new ResourceLocation("orespawn", "boyfriend17.png");
/*   80 */   private static final ResourceLocation DryTexture18 = new ResourceLocation("orespawn", "boyfriend18.png");
/*   81 */   private static final ResourceLocation DryTexture19 = new ResourceLocation("orespawn", "boyfriend19.png");
/*   82 */   private static final ResourceLocation DryTexture20 = new ResourceLocation("orespawn", "boyfriend20.png");
/*   83 */   private static final ResourceLocation DryTexture21 = new ResourceLocation("orespawn", "boyfriend21.png");
/*   84 */   private static final ResourceLocation DryTexture22 = new ResourceLocation("orespawn", "boyfriend22.png");
/*   85 */   private static final ResourceLocation DryTexture23 = new ResourceLocation("orespawn", "boyfriend23.png");
/*   86 */   private static final ResourceLocation DryTexture24 = new ResourceLocation("orespawn", "boyfriend24.png");
/*   87 */   private static final ResourceLocation DryTexture25 = new ResourceLocation("orespawn", "boyfriend25.png");
/*   88 */   private static final ResourceLocation DryTexture26 = new ResourceLocation("orespawn", "boyfriend26.png");
/*   89 */   private static final ResourceLocation DryTexture27 = new ResourceLocation("orespawn", "boyfriend27.png");
/*      */   
/*   91 */   private static final ResourceLocation WetTexture0 = new ResourceLocation("orespawn", "swimshorts0.png");
/*   92 */   private static final ResourceLocation WetTexture1 = new ResourceLocation("orespawn", "swimshorts1.png");
/*   93 */   private static final ResourceLocation WetTexture2 = new ResourceLocation("orespawn", "swimshorts2.png");
/*   94 */   private static final ResourceLocation WetTexture3 = new ResourceLocation("orespawn", "swimshorts3.png");
/*   95 */   private static final ResourceLocation WetTexture4 = new ResourceLocation("orespawn", "swimshorts4.png");
/*   96 */   private static final ResourceLocation WetTexture5 = new ResourceLocation("orespawn", "swimshorts5.png");
/*   97 */   private static final ResourceLocation WetTexture6 = new ResourceLocation("orespawn", "swimshorts6.png");
/*   98 */   private static final ResourceLocation WetTexture7 = new ResourceLocation("orespawn", "swimshorts7.png");
/*   99 */   private static final ResourceLocation WetTexture8 = new ResourceLocation("orespawn", "swimshorts8.png");
/*  100 */   private static final ResourceLocation WetTexture9 = new ResourceLocation("orespawn", "swimshorts9.png");
/*  101 */   private static final ResourceLocation WetTexture10 = new ResourceLocation("orespawn", "swimshorts10.png");
/*  102 */   private static final ResourceLocation WetTexture11 = new ResourceLocation("orespawn", "swimshorts11.png");
/*  103 */   private static final ResourceLocation WetTexture12 = new ResourceLocation("orespawn", "swimshorts12.png");
/*  104 */   private static final ResourceLocation WetTexture13 = new ResourceLocation("orespawn", "swimshorts13.png");
/*  105 */   private static final ResourceLocation WetTexture14 = new ResourceLocation("orespawn", "swimshorts14.png");
/*  106 */   private static final ResourceLocation WetTexture15 = new ResourceLocation("orespawn", "swimshorts15.png");
/*  107 */   private static final ResourceLocation WetTexture16 = new ResourceLocation("orespawn", "swimshorts16.png");
/*  108 */   private static final ResourceLocation WetTexture17 = new ResourceLocation("orespawn", "swimshorts17.png");
/*      */   
/*  110 */   private static final ResourceLocation PrinceTexture1 = new ResourceLocation("orespawn", "FrogPrince.png");
/*  111 */   private static final ResourceLocation PrinceTexture2 = new ResourceLocation("orespawn", "FrogPrince2.png");
/*      */ 
/*      */   
/*      */   public Boyfriend(World par1World) {
/*  115 */     super(par1World);
/*      */     
/*  117 */     this.which_guy = this.rand.nextInt(28);
/*  118 */     this.voice = this.rand.nextInt(10);
/*  119 */     this.which_wet_guy = this.rand.nextInt(18);
/*  120 */     setSize(0.5F, 1.6F);
/*  121 */     this.isImmuneToFire = true;
/*  122 */     this.fireResistance = 100;
/*      */ 
/*      */     
/*  125 */     getNavigator().setAvoidsWater(false);
/*  126 */     setSitting(false);
/*  127 */     this.tasks.addTask(1, new MyEntityAIFollowOwner(this, 1.4F, 12.0F, 1.5F));
/*  128 */     this.tasks.addTask(2, (EntityAIBase)new EntityAITempt((EntityCreature)this, 1.25D, Items.cooked_beef, false));
/*  129 */     this.tasks.addTask(4, (EntityAIBase)new EntityAIArrowAttack(this, 1.25D, 20, 10.0F));
/*  130 */     this.tasks.addTask(5, (EntityAIBase)new EntityAISwimming((EntityLiving)this));
/*  131 */     this.tasks.addTask(6, (EntityAIBase)new EntityAIPanic((EntityCreature)this, 1.5D));
/*  132 */     this.tasks.addTask(7, (EntityAIBase)new EntityAIWatchClosest((EntityLiving)this, EntityPlayer.class, 6.0F));
/*  133 */     this.tasks.addTask(8, new MyEntityAIWander((EntityCreature)this, 0.75F));
/*  134 */     this.tasks.addTask(9, (EntityAIBase)new EntityAILookIdle((EntityLiving)this));
/*  135 */     this.tasks.addTask(10, (EntityAIBase)new EntityAIOpenDoor((EntityLiving)this, true));
/*  136 */     this.tasks.addTask(11, (EntityAIBase)new EntityAIMoveIndoors((EntityCreature)this));
/*      */ 
/*      */     
/*  139 */     if (OreSpawnMain.PlayNicely == 0) this.targetTasks.addTask(2, new MyEntityAINearestAttackableTarget((EntityLiving)this, EntityCreeper.class, 20.0F, 0, true, true, IMob.mobSelector));
/*      */     
/*  141 */     if (OreSpawnMain.PlayNicely == 0) this.targetTasks.addTask(3, new MyEntityAINearestAttackableTarget((EntityLiving)this, EntityLiving.class, 15.0F, 0, true, true, IMob.mobSelector));
/*      */     
/*  143 */     if (OreSpawnMain.PlayNicely == 0) this.targetTasks.addTask(4, new MyEntityAIJealousy(this, Boyfriend.class, 6.0F, 5, true)); 
/*  144 */     if (OreSpawnMain.PlayNicely == 0) this.targetTasks.addTask(5, new MyEntityAIJealousy(this, Boyfriend.class, 3.0F, 15, true));
/*      */ 
/*      */     
/*  147 */     this.experienceValue = 0;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void entityInit() {
/*  152 */     super.entityInit();
/*      */     
/*  154 */     this.which_guy = this.rand.nextInt(28);
/*  155 */     this.dataWatcher.addObject(20, Integer.valueOf(this.which_guy));
/*  156 */     this.wet_count = 0;
/*  157 */     this.which_wet_guy = this.rand.nextInt(18);
/*  158 */     this.dataWatcher.addObject(22, Integer.valueOf(this.which_wet_guy));
/*  159 */     this.voice = this.rand.nextInt(10);
/*  160 */     this.dataWatcher.addObject(21, Integer.valueOf(this.voice));
/*  161 */     this.dataWatcher.addObject(23, Integer.valueOf(this.voice_enable));
/*  162 */     this.dataWatcher.addObject(24, Integer.valueOf(this.is_prince));
/*  163 */     this.auto_heal = 200;
/*  164 */     this.force_sync = 50;
/*  165 */     this.fight_sound_ticker = 0;
/*  166 */     this.taunt_sound_ticker = 0;
/*  167 */     this.had_target = 0;
/*  168 */     setSitting(false);
/*      */   }
/*      */ 
/*      */   
/*      */   protected void applyEntityAttributes() {
/*  173 */     super.applyEntityAttributes();
/*  174 */     getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(mygetMaxHealth());
/*  175 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  176 */     getAttributeMap().registerAttribute(SharedMonsterAttributes.attackDamage);
/*  177 */     getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(8.0D);
/*      */   }
/*      */ 
/*      */   
/*      */   public int getTotalArmorValue() {
/*  182 */     int i = 0;
/*  183 */     ItemStack[] aitemstack = getLastActiveItems();
/*  184 */     int j = aitemstack.length;
/*      */     
/*  186 */     for (int k = 0; k < j; k++) {
/*      */       
/*  188 */       ItemStack itemstack = aitemstack[k];
/*      */       
/*  190 */       if (itemstack != null && itemstack.getItem() instanceof ItemArmor) {
/*      */         
/*  192 */         int l = ((ItemArmor)itemstack.getItem()).damageReduceAmount;
/*  193 */         i += l;
/*      */       } 
/*      */     } 
/*  196 */     if (i < 8) i = 8; 
/*  197 */     if (i > 23) i = 23; 
/*  198 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onUpdate() {
/*  206 */     getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(this.moveSpeed);
/*  207 */     super.onUpdate();
/*  208 */     this.passenger = 0;
/*  209 */     if (isTamed() && !isSitting()) {
/*  210 */       EntityLivingBase entityLivingBase = getOwner();
/*  211 */       if (entityLivingBase != null && entityLivingBase instanceof EntityPlayer) {
/*  212 */         EntityPlayer p = (EntityPlayer)entityLivingBase;
/*  213 */         Entity r = ((Entity)entityLivingBase).ridingEntity;
/*  214 */         if (r != null && 
/*  215 */           r instanceof Elevator) {
/*      */ 
/*      */           
/*  218 */           float f = -0.45F;
/*  219 */           setPosition(r.posX - f * Math.sin(Math.toRadians(r.rotationYaw)), r.posY, r.posZ + f * Math.cos(Math.toRadians(r.rotationYaw)));
/*      */ 
/*      */           
/*  222 */           this.rotationYaw = r.rotationYaw;
/*  223 */           this.rotationPitch = r.rotationPitch;
/*      */           
/*  225 */           this.limbSwing = this.limbSwingAmount = 0.0F;
/*  226 */           this.fallDistance = 0.0F;
/*  227 */           this.passenger = 1;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
/*  240 */     super.writeEntityToNBT(par1NBTTagCompound);
/*  241 */     par1NBTTagCompound.setInteger("GirlType", getTameSkin());
/*  242 */     par1NBTTagCompound.setInteger("WetGirlType", getWetTameSkin());
/*  243 */     par1NBTTagCompound.setInteger("GirlVoice", this.dataWatcher.getWatchableObjectInt(21));
/*  244 */     par1NBTTagCompound.setInteger("GirlVoiceEnable", this.dataWatcher.getWatchableObjectInt(23));
/*  245 */     par1NBTTagCompound.setInteger("IsPrince", this.dataWatcher.getWatchableObjectInt(24));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
/*  254 */     super.readEntityFromNBT(par1NBTTagCompound);
/*  255 */     this.which_guy = par1NBTTagCompound.getInteger("GirlType");
/*  256 */     setTameSkin(this.which_guy);
/*  257 */     this.which_wet_guy = par1NBTTagCompound.getInteger("WetGirlType");
/*  258 */     setWetTameSkin(this.which_wet_guy);
/*  259 */     this.voice = par1NBTTagCompound.getInteger("GirlVoice");
/*  260 */     this.dataWatcher.updateObject(21, Integer.valueOf(this.voice));
/*  261 */     this.voice_enable = par1NBTTagCompound.getInteger("GirlVoiceEnable");
/*  262 */     this.dataWatcher.updateObject(23, Integer.valueOf(this.voice_enable));
/*  263 */     this.is_prince = par1NBTTagCompound.getInteger("IsPrince");
/*  264 */     this.dataWatcher.updateObject(24, Integer.valueOf(this.is_prince));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void updateAITick() {
/*  273 */     super.updateAITick();
/*      */     
/*  275 */     ItemStack stack = getCurrentEquippedItem();
/*  276 */     EntityLivingBase entityLivingBase = getAttackTarget();
/*  277 */     if (OreSpawnMain.PlayNicely != 0) entityLivingBase = null; 
/*  278 */     if (this.worldObj.rand.nextInt(100) == 1) setRevengeTarget(null);
/*      */     
/*  280 */     if (stack != null && !isSitting())
/*      */     {
/*  282 */       if (entityLivingBase != null) {
/*      */         
/*  284 */         if (entityLivingBase instanceof EntityLivingBase)
/*      */         {
/*  286 */           if (getHeldItem() != null)
/*      */           {
/*  288 */             if (getDistanceToEntity((Entity)entityLivingBase) < 4.0F || (stack.getItem() == OreSpawnMain.MyBertha && getDistanceToEntity((Entity)entityLivingBase) < 10.0F)) {
/*      */               
/*  290 */               this.attackTime--;
/*  291 */               if (this.attackTime <= 0)
/*      */               {
/*  293 */                 this.attackTime = 25;
/*      */                 
/*  295 */                 swingItem();
/*      */                 
/*  297 */                 attackTargetEntityWithCurrentItem((Entity)entityLivingBase);
/*  298 */                 this.fight_sound_ticker--;
/*  299 */                 if (this.fight_sound_ticker <= 0) {
/*      */                   
/*  301 */                   if (!this.worldObj.isRemote && this.voice_enable != 0) this.worldObj.playSoundAtEntity((Entity)this, "orespawn:b_fight", 0.5F, getSoundPitch()); 
/*  302 */                   this.fight_sound_ticker = 3;
/*      */                 } 
/*  304 */                 this.had_target = 1;
/*      */               }
/*      */             
/*  307 */             } else if (getDistanceToEntity((Entity)entityLivingBase) < 7.0F && stack.getItem() != OreSpawnMain.MyUltimateBow) {
/*      */               
/*  309 */               this.taunt_sound_ticker--;
/*  310 */               if (this.taunt_sound_ticker <= 0) {
/*      */                 
/*  312 */                 if (!this.worldObj.isRemote && this.voice_enable != 0) this.worldObj.playSoundAtEntity((Entity)this, "orespawn:b_taunt", 0.5F, getSoundPitch()); 
/*  313 */                 this.taunt_sound_ticker = 300;
/*      */               } 
/*      */               
/*  316 */               getNavigator().tryMoveToEntityLiving((Entity)entityLivingBase, 1.25D);
/*      */             } 
/*      */           }
/*      */         }
/*      */       } else {
/*      */         
/*  322 */         this.fight_sound_ticker = 0;
/*  323 */         this.attackTime = 0;
/*  324 */         if (this.had_target != 0) {
/*  325 */           this.had_target = 0;
/*  326 */           if (!this.worldObj.isRemote && this.voice_enable != 0) this.worldObj.playSoundAtEntity((Entity)this, "orespawn:b_woohoo", 0.4F, getSoundPitch());
/*      */         
/*      */         } 
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   public void setPrince(int par1) {
/*  334 */     this.is_prince = par1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ResourceLocation getTexture() {
/*  342 */     if (this.wet_count <= 0) {
/*      */       
/*  344 */       int txture = getTameSkin();
/*      */       
/*  346 */       if (this.is_prince == 1) return PrinceTexture1; 
/*  347 */       if (this.is_prince == 2) return PrinceTexture2;
/*      */       
/*  349 */       if (txture == 0) return DryTexture0; 
/*  350 */       if (txture == 1) return DryTexture1; 
/*  351 */       if (txture == 2) return DryTexture2; 
/*  352 */       if (txture == 3) return DryTexture3; 
/*  353 */       if (txture == 4) return DryTexture4; 
/*  354 */       if (txture == 5) return DryTexture5; 
/*  355 */       if (txture == 6) return DryTexture6; 
/*  356 */       if (txture == 7) return DryTexture7; 
/*  357 */       if (txture == 8) return DryTexture8; 
/*  358 */       if (txture == 9) return DryTexture9; 
/*  359 */       if (txture == 10) return DryTexture10; 
/*  360 */       if (txture == 11) return DryTexture11; 
/*  361 */       if (txture == 12) return DryTexture12; 
/*  362 */       if (txture == 13) return DryTexture13; 
/*  363 */       if (txture == 14) return DryTexture14; 
/*  364 */       if (txture == 15) return DryTexture15; 
/*  365 */       if (txture == 16) return DryTexture16; 
/*  366 */       if (txture == 17) return DryTexture17; 
/*  367 */       if (txture == 18) return DryTexture18; 
/*  368 */       if (txture == 19) return DryTexture19; 
/*  369 */       if (txture == 20) return DryTexture20; 
/*  370 */       if (txture == 21) return DryTexture21; 
/*  371 */       if (txture == 22) return DryTexture22; 
/*  372 */       if (txture == 23) return DryTexture23; 
/*  373 */       if (txture == 24) return DryTexture24; 
/*  374 */       if (txture == 25) return DryTexture25; 
/*  375 */       if (txture == 26) return DryTexture26; 
/*  376 */       if (txture == 27) return DryTexture27;
/*      */     
/*      */     } else {
/*  379 */       int temp = getWetTameSkin();
/*      */       
/*  381 */       if (temp == 0) return WetTexture0; 
/*  382 */       if (temp == 1) return WetTexture1; 
/*  383 */       if (temp == 2) return WetTexture2; 
/*  384 */       if (temp == 3) return WetTexture3; 
/*  385 */       if (temp == 4) return WetTexture4; 
/*  386 */       if (temp == 5) return WetTexture5; 
/*  387 */       if (temp == 6) return WetTexture6; 
/*  388 */       if (temp == 7) return WetTexture7; 
/*  389 */       if (temp == 8) return WetTexture8; 
/*  390 */       if (temp == 9) return WetTexture9; 
/*  391 */       if (temp == 10) return WetTexture10; 
/*  392 */       if (temp == 11) return WetTexture11; 
/*  393 */       if (temp == 12) return WetTexture12; 
/*  394 */       if (temp == 13) return WetTexture13; 
/*  395 */       if (temp == 14) return WetTexture14; 
/*  396 */       if (temp == 15) return WetTexture15; 
/*  397 */       if (temp == 16) return WetTexture16; 
/*  398 */       if (temp == 17) return WetTexture17;
/*      */     
/*      */     } 
/*      */     
/*  402 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getTameSkin() {
/*  408 */     return this.dataWatcher.getWatchableObjectInt(20);
/*      */   }
/*      */   
/*      */   public int getVoice() {
/*  412 */     return this.dataWatcher.getWatchableObjectInt(21);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setTameSkin(int par1) {
/*  417 */     this.dataWatcher.updateObject(20, Integer.valueOf(par1));
/*  418 */     this.which_guy = par1;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getWetTameSkin() {
/*  423 */     return this.dataWatcher.getWatchableObjectInt(22);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setWetTameSkin(int par1) {
/*  428 */     this.dataWatcher.updateObject(22, Integer.valueOf(par1));
/*  429 */     this.which_wet_guy = par1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isAIEnabled() {
/*  437 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canBreatheUnderwater() {
/*  443 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void fall(float par1) {
/*  449 */     float i = MathHelper.ceiling_float_int(par1 - 3.0F);
/*      */     
/*  451 */     if (i > 0.0F) {
/*      */       
/*  453 */       if (i > 3.0F) {
/*      */         
/*  455 */         playSound("damage.fallbig", 1.0F, 1.0F);
/*  456 */         i = 3.0F;
/*      */       }
/*      */       else {
/*      */         
/*  460 */         playSound("damage.fallsmall", 1.0F, 1.0F);
/*      */       } 
/*      */       
/*  463 */       attackEntityFrom(DamageSource.fall, i);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int mygetMaxHealth() {
/*  470 */     return 80;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void onLivingUpdate() {
/*  479 */     updateArmSwingProgress();
/*      */     
/*  481 */     super.onLivingUpdate();
/*      */ 
/*      */ 
/*      */     
/*  485 */     if (isInWater() || handleLavaMovement()) {
/*  486 */       this.wet_count = 500;
/*      */     }
/*  488 */     else if (this.wet_count > 0) {
/*  489 */       this.wet_count--;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  496 */     this.auto_heal--;
/*  497 */     if (this.auto_heal <= 0) {
/*  498 */       if (mygetMaxHealth() > getBoyfriendHealth())
/*      */       {
/*  500 */         heal(1.0F);
/*      */       }
/*      */       
/*  503 */       this.auto_heal = 150;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  511 */     this.force_sync--;
/*  512 */     if (this.force_sync <= 0) {
/*  513 */       this.force_sync = 20;
/*  514 */       if (!this.worldObj.isRemote) {
/*      */         
/*  516 */         this.dataWatcher.updateObject(21, Integer.valueOf(this.voice));
/*  517 */         this.dataWatcher.updateObject(23, Integer.valueOf(this.voice_enable));
/*  518 */         this.dataWatcher.updateObject(24, Integer.valueOf(this.is_prince));
/*  519 */         setSitting(isSitting());
/*      */       } else {
/*      */         
/*  522 */         this.voice = getVoice();
/*  523 */         this.voice_enable = this.dataWatcher.getWatchableObjectInt(23);
/*  524 */         this.is_prince = this.dataWatcher.getWatchableObjectInt(24);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getBoyfriendHealth() {
/*  542 */     return (int)getHealth();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean interact(EntityPlayer par1EntityPlayer) {
/*  550 */     ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
/*      */ 
/*      */     
/*  553 */     if (var2 != null)
/*      */     {
/*  555 */       if (var2.stackSize <= 0) {
/*      */         
/*  557 */         par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*  558 */         var2 = null;
/*      */       } 
/*      */     }
/*      */     
/*  562 */     if (var2 != null && (var2.getItem() == Items.cooked_beef || var2.getItem() == OreSpawnMain.MyPeacock) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D) {
/*      */       
/*  564 */       if (!isTamed()) {
/*      */         
/*  566 */         if (!this.worldObj.isRemote)
/*      */         {
/*  568 */           if (this.worldObj.rand.nextInt(3) == 0)
/*      */           {
/*  570 */             setTamed(true);
/*  571 */             func_152115_b(par1EntityPlayer.getUniqueID().toString());
/*  572 */             playTameEffect(true);
/*  573 */             this.worldObj.setEntityState((Entity)this, (byte)7);
/*  574 */             heal(mygetMaxHealth() - getHealth());
/*      */           
/*      */           }
/*      */           else
/*      */           {
/*  579 */             playTameEffect(false);
/*  580 */             this.worldObj.setEntityState((Entity)this, (byte)6);
/*      */           }
/*      */         
/*      */         }
/*      */       }
/*  585 */       else if (isOwner((EntityLivingBase)par1EntityPlayer)) {
/*      */         
/*  587 */         if (this.worldObj.isRemote) {
/*  588 */           playTameEffect(true);
/*  589 */           this.worldObj.setEntityState((Entity)this, (byte)7);
/*      */         } 
/*      */         
/*  592 */         if (mygetMaxHealth() > getHealth()) {
/*  593 */           heal(mygetMaxHealth() - getHealth());
/*      */         }
/*      */       } 
/*      */       
/*  597 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */         
/*  599 */         var2.stackSize--;
/*  600 */         if (var2.stackSize <= 0)
/*      */         {
/*  602 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */         }
/*      */       } 
/*  605 */       return true;
/*      */     } 
/*  607 */     if (isTamed() && var2 != null && var2.getItem() == Item.getItemFromBlock((Block)Blocks.deadbush) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*      */ 
/*      */       
/*  610 */       if (!this.worldObj.isRemote) {
/*      */         
/*  612 */         setTamed(false);
/*  613 */         func_152115_b("");
/*  614 */         playTameEffect(false);
/*  615 */         this.worldObj.setEntityState((Entity)this, (byte)6);
/*      */       } 
/*      */       
/*  618 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */         
/*  620 */         var2.stackSize--;
/*  621 */         if (var2.stackSize <= 0)
/*      */         {
/*  623 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */         }
/*      */       } 
/*  626 */       return true;
/*      */     } 
/*      */     
/*  629 */     if (isTamed() && var2 != null && var2.getItem() == OreSpawnMain.MyRuby && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*      */ 
/*      */       
/*  632 */       if (!this.worldObj.isRemote) {
/*      */         
/*  634 */         this.voice_enable = 0;
/*  635 */         this.dataWatcher.updateObject(23, Integer.valueOf(this.voice_enable));
/*  636 */         playTameEffect(true);
/*  637 */         this.worldObj.setEntityState((Entity)this, (byte)7);
/*      */       } 
/*      */       
/*  640 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */         
/*  642 */         var2.stackSize--;
/*  643 */         if (var2.stackSize <= 0)
/*      */         {
/*  645 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */         }
/*      */       } 
/*  648 */       return true;
/*      */     } 
/*  650 */     if (isTamed() && var2 != null && var2.getItem() == OreSpawnMain.MyAmethyst && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*      */ 
/*      */       
/*  653 */       if (!this.worldObj.isRemote) {
/*      */         
/*  655 */         this.voice_enable = 1;
/*  656 */         this.dataWatcher.updateObject(23, Integer.valueOf(this.voice_enable));
/*  657 */         playTameEffect(true);
/*  658 */         this.worldObj.setEntityState((Entity)this, (byte)7);
/*      */       } 
/*      */       
/*  661 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */         
/*  663 */         var2.stackSize--;
/*  664 */         if (var2.stackSize <= 0)
/*      */         {
/*  666 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */         }
/*      */       } 
/*  669 */       return true;
/*      */     } 
/*  671 */     if (isTamed() && var2 != null && (var2.getItem() == Items.leather || var2.getItem() == OreSpawnMain.MyPeacockFeather) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*      */ 
/*      */       
/*  674 */       if (!this.worldObj.isRemote)
/*      */       {
/*  676 */         if (this.wet_count > 0 || isInWater() || handleLavaMovement()) {
/*  677 */           this.which_wet_guy++;
/*  678 */           if (this.which_wet_guy > 17) this.which_wet_guy = 0; 
/*  679 */           setWetTameSkin(this.which_wet_guy);
/*  680 */           this.worldObj.setEntityState((Entity)this, (byte)7);
/*  681 */           if (isInWater() || handleLavaMovement()) {
/*  682 */             this.wet_count = 500;
/*      */           }
/*      */         } else {
/*  685 */           this.which_guy++;
/*  686 */           if (this.which_guy > 27) this.which_guy = 0; 
/*  687 */           setTameSkin(this.which_guy);
/*  688 */           this.worldObj.setEntityState((Entity)this, (byte)7);
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/*  693 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */         
/*  695 */         var2.stackSize--;
/*  696 */         if (var2.stackSize <= 0)
/*      */         {
/*  698 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */         }
/*      */       } 
/*  701 */       return true;
/*  702 */     }  if (isTamed() && var2 != null && isOwner((EntityLivingBase)par1EntityPlayer) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D) {
/*      */ 
/*      */       
/*  705 */       if (var2.getItem() instanceof ItemFood) {
/*      */         
/*  707 */         if (!this.worldObj.isRemote) {
/*      */ 
/*      */           
/*  710 */           ItemFood var3 = (ItemFood)var2.getItem();
/*      */           
/*  712 */           if (mygetMaxHealth() > getHealth())
/*      */           {
/*  714 */             heal((var3.getHealAmount(var2) * 5));
/*      */           }
/*      */           
/*  717 */           playTameEffect(true);
/*  718 */           this.worldObj.setEntityState((Entity)this, (byte)7);
/*      */         } 
/*      */         
/*  721 */         if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */           
/*  723 */           var2.stackSize--;
/*  724 */           if (var2.stackSize <= 0)
/*      */           {
/*  726 */             par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */           }
/*      */         } 
/*      */       } else {
/*  730 */         if (!this.worldObj.isRemote) {
/*      */ 
/*      */ 
/*      */           
/*  734 */           playTameEffect(true);
/*  735 */           this.worldObj.setEntityState((Entity)this, (byte)7);
/*      */         } 
/*      */         
/*  738 */         ItemStack var3 = getCurrentEquippedItem();
/*  739 */         setCurrentItemOrArmor(0, var2);
/*  740 */         if (var2.getItem() == Items.diamond) {
/*  741 */           setSitting(true);
/*      */         } else {
/*  743 */           setSitting(false);
/*      */         } 
/*      */         
/*  746 */         if (var3 != null) {
/*  747 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, var3);
/*      */         } else {
/*      */           
/*  750 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*  751 */           Item itm = var2.getItem();
/*  752 */           if (itm instanceof ItemOreSpawnArmor) {
/*  753 */             if (itm == OreSpawnMain.EmeraldHelmet || itm == OreSpawnMain.AmethystHelmet || itm == OreSpawnMain.UltimateHelmet) {
/*  754 */               ItemStack v4 = getEquipmentInSlot(4);
/*  755 */               setCurrentItemOrArmor(4, var2);
/*  756 */               setCurrentItemOrArmor(0, v4);
/*      */             } 
/*  758 */             if (itm == OreSpawnMain.EmeraldBody || itm == OreSpawnMain.AmethystBody || itm == OreSpawnMain.UltimateBody) {
/*  759 */               ItemStack v4 = getEquipmentInSlot(3);
/*  760 */               setCurrentItemOrArmor(3, var2);
/*  761 */               setCurrentItemOrArmor(0, v4);
/*      */             } 
/*  763 */             if (itm == OreSpawnMain.EmeraldLegs || itm == OreSpawnMain.AmethystLegs || itm == OreSpawnMain.UltimateLegs) {
/*  764 */               ItemStack v4 = getEquipmentInSlot(2);
/*  765 */               setCurrentItemOrArmor(2, var2);
/*  766 */               setCurrentItemOrArmor(0, v4);
/*      */             } 
/*  768 */             if (itm == OreSpawnMain.EmeraldBoots || itm == OreSpawnMain.AmethystBoots || itm == OreSpawnMain.UltimateBoots) {
/*  769 */               ItemStack v4 = getEquipmentInSlot(1);
/*  770 */               setCurrentItemOrArmor(1, var2);
/*  771 */               setCurrentItemOrArmor(0, v4);
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/*  778 */       return true;
/*      */     } 
/*  780 */     if (isTamed() && var2 != null && var2.getItem() == Item.getItemFromBlock(Blocks.diamond_block) && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D) {
/*      */       
/*  782 */       setSitting(false);
/*  783 */       setTamed(true);
/*  784 */       func_152115_b(par1EntityPlayer.getUniqueID().toString());
/*  785 */       playTameEffect(true);
/*  786 */       this.worldObj.setEntityState((Entity)this, (byte)7);
/*  787 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */         
/*  789 */         var2.stackSize--;
/*  790 */         if (var2.stackSize <= 0)
/*      */         {
/*  792 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */         }
/*      */       } 
/*  795 */       return true;
/*  796 */     }  if (isTamed() && var2 != null && var2.getItem() == Items.name_tag && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*      */       
/*  798 */       setCustomNameTag(var2.getDisplayName());
/*  799 */       if (!par1EntityPlayer.capabilities.isCreativeMode) {
/*      */         
/*  801 */         var2.stackSize--;
/*  802 */         if (var2.stackSize <= 0)
/*      */         {
/*  804 */           par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
/*      */         }
/*      */       } 
/*  807 */       return true;
/*      */     } 
/*  809 */     if (isTamed() && var2 == null && par1EntityPlayer.getDistanceSqToEntity((Entity)this) < 16.0D && isOwner((EntityLivingBase)par1EntityPlayer)) {
/*      */ 
/*      */       
/*  812 */       ItemStack var3 = getEquipmentInSlot(0);
/*  813 */       int it = 0;
/*  814 */       if (var3 == null) {
/*  815 */         it++;
/*  816 */         var3 = getEquipmentInSlot(it);
/*      */       } 
/*  818 */       if (var3 == null) {
/*  819 */         it++;
/*  820 */         var3 = getEquipmentInSlot(it);
/*      */       } 
/*  822 */       if (var3 == null) {
/*  823 */         it++;
/*  824 */         var3 = getEquipmentInSlot(it);
/*      */       } 
/*  826 */       if (var3 == null) {
/*  827 */         it++;
/*  828 */         var3 = getEquipmentInSlot(it);
/*      */       } 
/*  830 */       if (var3 != null) {
/*  831 */         par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, var3);
/*  832 */         setCurrentItemOrArmor(it, null);
/*  833 */         setSitting(false);
/*  834 */         if (!this.worldObj.isRemote)
/*      */         {
/*  836 */           this.worldObj.setEntityState((Entity)this, (byte)6);
/*      */         }
/*      */       }
/*  839 */       else if (!this.worldObj.isRemote) {
/*      */         
/*  841 */         setSitting(false);
/*  842 */         playTameEffect(true);
/*  843 */         this.worldObj.setEntityState((Entity)this, (byte)7);
/*  844 */         String healthMessage = new String();
/*  845 */         healthMessage = String.format("I have %d health. Thanks for asking!", new Object[] { Integer.valueOf(getBoyfriendHealth()) });
/*      */ 
/*      */         
/*  848 */         par1EntityPlayer.addChatComponentMessage((IChatComponent)new ChatComponentText(healthMessage));
/*      */       } 
/*      */       
/*  851 */       return true;
/*      */     } 
/*      */     
/*  854 */     return super.interact(par1EntityPlayer);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isWheat(ItemStack par1ItemStack) {
/*  863 */     if (par1ItemStack != null && (
/*  864 */       par1ItemStack.getItem() == Items.cooked_beef || par1ItemStack.getItem() == OreSpawnMain.MyPeacock)) return true;
/*      */ 
/*      */     
/*  867 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean canDespawn() {
/*  875 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getLivingSound() {
/*  883 */     if (isSitting() || this.voice_enable == 0)
/*      */     {
/*  885 */       return null;
/*      */     }
/*      */     
/*  888 */     if (OreSpawnMain.bro_mode != 0 && this.worldObj.rand.nextInt(2) == 1) return null;
/*      */     
/*  890 */     if (this.worldObj.rand.nextInt(11) == 1) {
/*      */       
/*  892 */       EntityLivingBase entityLivingBase = getAttackTarget();
/*  893 */       if (entityLivingBase != null) {
/*  894 */         return null;
/*      */       }
/*      */       
/*  897 */       if (isInWater() || handleLavaMovement()) {
/*  898 */         return "orespawn:b_water";
/*      */       }
/*      */       
/*  901 */       if (this.worldObj.rand.nextInt(4) != 0) {
/*      */         
/*  903 */         if (this.posY < 60.0D) {
/*  904 */           return null;
/*      */         }
/*      */         
/*  907 */         if (this.worldObj.isThundering()) {
/*  908 */           return "orespawn:b_thunder";
/*      */         }
/*      */         
/*  911 */         if (this.worldObj.isRaining()) {
/*  912 */           return "orespawn:b_rain";
/*      */         }
/*      */         
/*  915 */         if (!this.worldObj.isDaytime() && 
/*  916 */           this.worldObj.canBlockSeeTheSky((int)this.posX, (int)this.posY, (int)this.posZ)) {
/*  917 */           if (this.worldObj.rand.nextInt(3) == 0) return "orespawn:b_dark"; 
/*  918 */           return null;
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/*  923 */       if (isTamed()) {
/*      */         
/*  925 */         if (mygetMaxHealth() > getHealth()) {
/*  926 */           return "orespawn:b_hurt";
/*      */         }
/*  928 */         if (OreSpawnMain.bro_mode != 0) return "orespawn:bb_happy"; 
/*  929 */         return "orespawn:b_happy";
/*      */       } 
/*  931 */       return null;
/*      */     } 
/*      */ 
/*      */     
/*  935 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getHurtSound() {
/*  944 */     if (this.voice_enable == 0)
/*      */     {
/*  946 */       return null;
/*      */     }
/*  948 */     if (OreSpawnMain.bro_mode != 0 && this.worldObj.rand.nextInt(2) == 1) return null; 
/*  949 */     return "orespawn:b_ow";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getDeathSound() {
/*  957 */     if (OreSpawnMain.bro_mode != 0) return null; 
/*  958 */     return isTamed() ? "orespawn:b_death_boyfriend" : "orespawn:b_death_single";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected float getSoundVolume() {
/*  966 */     return 0.3F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Item getDropItem() {
/*  974 */     return Item.getItemFromBlock((Block)Blocks.red_flower);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void dropFewItems(boolean par1, int par2) {
/*  982 */     int var3 = 0;
/*      */     
/*  984 */     if (isTamed()) {
/*      */       
/*  986 */       var3 = this.rand.nextInt(5);
/*  987 */       var3 += 2;
/*  988 */       for (int i = 0; i < var3; i++)
/*      */       {
/*  990 */         dropItem(Item.getItemFromBlock((Block)Blocks.red_flower), 1);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  995 */     Item v6 = OreSpawnMain.MyItemGameController;
/*      */ 
/*      */     
/*  998 */     var3 = this.worldObj.rand.nextInt(26);
/*  999 */     var3 += 10;
/* 1000 */     for (int var4 = 0; var4 < var3; var4++)
/*      */     {
/* 1002 */       dropItem(v6, 1);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 1007 */     if (isTamed()) {
/*      */       
/* 1009 */       ItemStack var5 = getCurrentEquippedItem();
/* 1010 */       if (var5 != null && 
/* 1011 */         var5.stackSize > 0) {
/* 1012 */         dropItem(var5.getItem(), var5.stackSize);
/*      */       }
/*      */       
/* 1015 */       var5 = getEquipmentInSlot(1);
/* 1016 */       if (var5 != null && 
/* 1017 */         var5.stackSize > 0) {
/* 1018 */         dropItem(var5.getItem(), var5.stackSize);
/*      */       }
/*      */       
/* 1021 */       var5 = getEquipmentInSlot(2);
/* 1022 */       if (var5 != null && 
/* 1023 */         var5.stackSize > 0) {
/* 1024 */         dropItem(var5.getItem(), var5.stackSize);
/*      */       }
/*      */       
/* 1027 */       var5 = getEquipmentInSlot(3);
/* 1028 */       if (var5 != null && 
/* 1029 */         var5.stackSize > 0) {
/* 1030 */         dropItem(var5.getItem(), var5.stackSize);
/*      */       }
/*      */       
/* 1033 */       var5 = getEquipmentInSlot(4);
/* 1034 */       if (var5 != null && 
/* 1035 */         var5.stackSize > 0) {
/* 1036 */         dropItem(var5.getItem(), var5.stackSize);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void attackEntityWithRangedAttack(EntityLivingBase par1EntityLiving) {
/* 1046 */     ItemStack it = null;
/* 1047 */     if (this.isSwingInProgress) {
/*      */       return;
/*      */     }
/*      */     
/* 1051 */     it = getCurrentEquippedItem();
/* 1052 */     if (it != null && it.getItem() == OreSpawnMain.MyUltimateBow) {
/*      */       
/* 1054 */       EntityArrow var8 = new UltimateArrow(this.worldObj, (EntityLiving)this, par1EntityLiving, 2.0F, 10.0F);
/*      */ 
/*      */       
/* 1057 */       if (this.worldObj.rand.nextInt(4) == 1) var8.setIsCritical(true);
/*      */       
/* 1059 */       int var10 = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, it);
/* 1060 */       if (var10 > 0)
/*      */       {
/* 1062 */         var8.setKnockbackStrength(var10);
/*      */       }
/*      */       
/* 1065 */       if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, it) > 0)
/*      */       {
/* 1067 */         var8.setFire(100);
/*      */       }
/*      */       
/* 1070 */       it.damageItem(1, (EntityLivingBase)this);
/* 1071 */       this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 1.0F, 1.0F / (this.worldObj.rand.nextFloat() * 0.4F + 1.2F) + 0.5F);
/*      */       
/* 1073 */       var8.canBePickedUp = 2;
/*      */       
/* 1075 */       this.worldObj.spawnEntityInWorld((Entity)var8);
/*      */     } else {
/*      */       
/* 1078 */       Shoes var2 = new Shoes(this.worldObj, (EntityLivingBase)this, 6);
/* 1079 */       double var3 = par1EntityLiving.posX - this.posX;
/* 1080 */       double var5 = par1EntityLiving.posY + par1EntityLiving.getEyeHeight() - 1.1D - var2.posY;
/* 1081 */       double var7 = par1EntityLiving.posZ - this.posZ;
/* 1082 */       float var9 = MathHelper.sqrt_double(var3 * var3 + var7 * var7) * 0.2F;
/* 1083 */       var2.setThrowableHeading(var3, var5 + var9, var7, 1.8F, 4.0F);
/* 1084 */       this.worldObj.playSoundAtEntity((Entity)this, "random.bow", 0.75F, 1.0F / (getRNG().nextFloat() * 0.4F + 0.8F));
/* 1085 */       this.worldObj.spawnEntityInWorld((Entity)var2);
/*      */     } 
/* 1087 */     swingItem();
/*      */   }
/*      */ 
/*      */   
/*      */   public ItemStack getCurrentEquippedItem() {
/* 1092 */     return getEquipmentInSlot(0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void attackTargetEntityWithCurrentItem(Entity par1Entity) {
/* 1100 */     ItemStack stack = getCurrentEquippedItem();
/*      */ 
/*      */     
/* 1103 */     if (stack != null) {
/*      */       
/* 1105 */       float var2 = 0.0F;
/*      */       
/* 1107 */       if (isPotionActive(Potion.damageBoost))
/*      */       {
/* 1109 */         var2 += (3 << getActivePotionEffect(Potion.damageBoost).getAmplifier());
/*      */       }
/*      */       
/* 1112 */       if (isPotionActive(Potion.weakness))
/*      */       {
/* 1114 */         var2 -= (2 << getActivePotionEffect(Potion.weakness).getAmplifier());
/*      */       }
/*      */       
/* 1117 */       int var3 = 0;
/* 1118 */       float var4 = (float)getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
/*      */       
/* 1120 */       if (par1Entity instanceof EntityLiving) {
/*      */         
/* 1122 */         var4 += EnchantmentHelper.getEnchantmentModifierLiving((EntityLivingBase)this, (EntityLivingBase)par1Entity);
/* 1123 */         var3 += EnchantmentHelper.getKnockbackModifier((EntityLivingBase)this, (EntityLivingBase)par1Entity);
/*      */       } 
/*      */       
/* 1126 */       if (isSprinting())
/*      */       {
/* 1128 */         var3++;
/*      */       }
/*      */       
/* 1131 */       if (var2 > 0.0F || var4 > 0.0F) {
/*      */         
/* 1133 */         boolean var5 = (this.fallDistance > 0.0F && !this.onGround && !isOnLadder() && !isInWater() && !handleLavaMovement() && !isPotionActive(Potion.blindness) && this.ridingEntity == null && par1Entity instanceof EntityLiving);
/*      */         
/* 1135 */         if (var5)
/*      */         {
/* 1137 */           var2 += this.worldObj.rand.nextInt((int)var2 / 2 + 2);
/*      */         }
/*      */         
/* 1140 */         var2 += var4;
/* 1141 */         boolean var6 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage((EntityLivingBase)this), var2);
/*      */         
/* 1143 */         if (var6)
/*      */         {
/* 1145 */           if (var3 > 0) {
/*      */             
/* 1147 */             par1Entity.addVelocity((-MathHelper.sin(this.rotationYaw * 3.1415927F / 180.0F) * var3 * 0.5F), 0.1D, (MathHelper.cos(this.rotationYaw * 3.1415927F / 180.0F) * var3 * 0.5F));
/* 1148 */             this.motionX *= 0.6D;
/* 1149 */             this.motionZ *= 0.6D;
/* 1150 */             setSprinting(false);
/*      */           } 
/*      */         }
/*      */ 
/*      */ 
/*      */         
/* 1156 */         ItemStack var7 = getCurrentEquippedItem();
/*      */ 
/*      */         
/* 1159 */         if (par1Entity instanceof EntityLiving) {
/*      */ 
/*      */           
/* 1162 */           int var8 = EnchantmentHelper.getEnchantmentLevel(Enchantment.fireAspect.effectId, var7);
/*      */           
/* 1164 */           if (var8 > 0 && var6)
/*      */           {
/* 1166 */             par1Entity.setFire(var8 * 4);
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected float getSoundPitch() {
/* 1182 */     return (this.voice - 5) * 0.02F + 1.0F;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public EntityAgeable createChild(EntityAgeable var1) {
/* 1188 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void attackEntityWithRangedAttack(EntityLivingBase entityliving, float f) {
/* 1194 */     attackEntityWithRangedAttack(entityliving);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean attackEntityFrom(DamageSource par1DamageSource, float par2) {
/* 1202 */     boolean ret = false;
/* 1203 */     float p2 = par2;
/* 1204 */     if (p2 > 10.0F) p2 = 10.0F; 
/* 1205 */     if (!par1DamageSource.getDamageType().equals("cactus")) {
/* 1206 */       ret = super.attackEntityFrom(par1DamageSource, p2);
/*      */     }
/* 1208 */     return ret;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getCanSpawnHere() {
/* 1217 */     for (int k = -3; k < 3; k++) {
/*      */       
/* 1219 */       for (int j = -3; j < 3; j++) {
/*      */         
/* 1221 */         for (int i = 0; i < 5; i++) {
/*      */           
/* 1223 */           Block bid = this.worldObj.getBlock((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 1224 */           if (bid == Blocks.mob_spawner) {
/* 1225 */             TileEntityMobSpawner tileentitymobspawner = null;
/* 1226 */             tileentitymobspawner = (TileEntityMobSpawner)this.worldObj.getTileEntity((int)this.posX + j, (int)this.posY + i, (int)this.posZ + k);
/* 1227 */             String s = tileentitymobspawner.getSpawnerBaseLogic().getEntityNameToSpawn();
/* 1228 */             if (s != null && 
/* 1229 */               s.equals("Boyfriend")) {
/* 1230 */               return true;
/*      */             }
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1238 */     return super.getCanSpawnHere();
/*      */   }
/*      */ }


/* Location:              C:\Users\Admin\Downloads\orespawn-1.7.10-20.3-deobf.jar!\danger\orespawn\Boyfriend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */