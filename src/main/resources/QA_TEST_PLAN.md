# QA Test Plan: Gouda Blade

Generated: 2026-01-07T13:58:15.843Z
Minecraft Version: 1.21.1
Mod ID: goudablade

## Audit Summary

| Metric | Count |
|--------|-------|
| Total Checks | 55 |
| Passed | 47 |
| Failed | 4 |
| Warnings | 2 |
| Skipped | 2 |
| **Overall** | **FAILED** |

## Test Setup

1. Install Fabric Loader for Minecraft 1.21.1
2. Install Fabric API
3. Place `goudablade.jar` in mods folder
4. Launch Minecraft
5. Create new creative world or use existing test world

## Items Checklist

| Item | Get Command | Texture | Recipe | Functionality |
|------|-------------|---------|--------|---------------|
| Cheese Slice | `/give @p goudablade:cheese_slice` | ☐ | ☐ | ☐ |
| Cheese Sword | `/give @p goudablade:cheese_sword` | ☐ | ☐ | ☐ |
| Pungent Milk Pod | `/give @p goudablade:pungent_milk_pod` | ☐ | ☐ | ☐ |
| Cheese Seed | `/give @p goudablade:cheese_seed` | ☐ | ☐ | ☐ |
| 4x Cheese Slice | `/give @p goudablade:4x_cheese_slice` | ☐ | ☐ | ☐ |
| Minecraftcobblestone | `/give @p goudablade:minecraftcobblestone` | ☐ | ☐ | ☐ |

### Item Tests

#### Cheese Slice

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Cheese Slice"
- [ ] Crafting recipe works
- [ ] Right-click action works: effect
- [ ] Cooldown applies (100 ticks)

#### Cheese Sword

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Cheese Sword"
- [ ] Crafting recipe works
- [ ] Tool functions correctly
- [ ] Durability depletes on use

#### Pungent Milk Pod

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Pungent Milk Pod"
- [ ] Crafting recipe works

#### Cheese Seed

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Cheese Seed"
- [ ] Crafting recipe works

#### 4x Cheese Slice

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "4x Cheese Slice"

#### Minecraftcobblestone

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Minecraftcobblestone"

## Blocks Checklist

| Block | Get Command | Texture | Place | Break |
|-------|-------------|---------|-------|-------|
| Cheese Plant | `/give @p goudablade:cheese_plant` | ☐ | ☐ | ☐ |
| Cheese Block | `/give @p goudablade:cheese_block` | ☐ | ☐ | ☐ |
| Cheese Rock | `/give @p goudablade:cheese_rock` | ☐ | ☐ | ☐ |

## Structures Checklist

### Cheese Cavern
- [ ] Structure generates in world
- [ ] Use `/locate structure goudablade:cheese_cavern` to find
- [ ] Contains expected features

## Notes

- Test in both creative and survival modes
- Check for console errors/warnings
- Verify no crashes on world load/unload
- Test multiplayer compatibility if applicable
