# QA Test Plan: Stormcallers Rod

Generated: 2025-12-28T01:07:49.758Z
Minecraft Version: 1.21.1
Mod ID: stormcallersrod

## Audit Summary

| Metric | Count |
|--------|-------|
| Total Checks | 28 |
| Passed | 22 |
| Failed | 0 |
| Warnings | 2 |
| Skipped | 4 |
| **Overall** | **WARN** |

## Test Setup

1. Install Fabric Loader for Minecraft 1.21.1
2. Install Fabric API
3. Place `stormcallersrod.jar` in mods folder
4. Launch Minecraft
5. Create new creative world or use existing test world

## Items Checklist

| Item | Get Command | Texture | Recipe | Functionality |
|------|-------------|---------|--------|---------------|
| Power Shard | `/give @p stormcallersrod:power_shard` | ☐ | ☐ | ☐ |
| Lightning Wand | `/give @p stormcallersrod:lightning_wand` | ☐ | ☐ | ☐ |

### Item Tests

#### Power Shard

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Power Shard"
- [ ] Crafting recipe works

#### Lightning Wand

- [ ] Item appears in creative tab
- [ ] Texture displays correctly (not purple/black)
- [ ] Name displays correctly: "Lightning Wand"
- [ ] Crafting recipe works
- [ ] Right-click action works: projectile
- [ ] Cooldown applies (20 ticks)

## Notes

- Test in both creative and survival modes
- Check for console errors/warnings
- Verify no crashes on world load/unload
- Test multiplayer compatibility if applicable
